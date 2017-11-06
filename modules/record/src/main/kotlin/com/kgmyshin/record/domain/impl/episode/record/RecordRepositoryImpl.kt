package com.kgmyshin.record.domain.impl.episode.record

import android.util.LruCache
import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.Record
import com.kgmyshin.record.domain.episode.record.RecordRepository
import com.kgmyshin.record.infra.api.RecordApiClient
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Named

internal class RecordRepositoryImpl(
        private val apiClient: RecordApiClient,
        private val getAccessTokenService: GetAccessTokenService,
        @Named("io") private val ioScheduler: Scheduler
) : RecordRepository {

    private val episodeIdCache: LruCache<EpisodeId, List<Record>> = LruCache(1000)

    override fun findByEpisodeId(episodeId: EpisodeId): Single<List<Record>> =
            if (episodeIdCache.get(episodeId) != null) {
                Single.just(episodeIdCache.get(episodeId))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getRecords(
                            filterEpisodeId = episodeId.value,
                            accessToken = accessToken
                    )
                }.map {
                    RecordConverter.convertToRecord(it.recordList)
                }.doOnSuccess { recordList ->
                    episodeIdCache.put(
                            episodeId,
                            recordList
                    )
                }.subscribeOn(ioScheduler)
            }

    override fun create(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Record> =
            getAccessTokenService.execute().flatMap { accessToken ->
                apiClient.createRecord(
                        episodeId = record.episodeId.value,
                        comment = record.comment,
                        ratingState = record.ratingState.rawValue,
                        shareFacebook = shareFacebook,
                        shareTwitter = shareTwitter,
                        accessToken = accessToken
                )
            }.map {
                RecordConverter.convertToRecord(it)
            }.doOnSuccess { createdRecord ->
                episodeIdCache.get(createdRecord.episodeId)?.let {
                    episodeIdCache.put(
                            createdRecord.episodeId,
                            listOf(createdRecord).plus(it)
                    )
                }
            }.subscribeOn(ioScheduler)

    override fun update(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Record> =
            getAccessTokenService.execute().flatMap { accessToken ->
                apiClient.updateRecord(
                        id = record.id.value,
                        comment = record.comment,
                        ratingState = record.ratingState.rawValue,
                        shareFacebook = shareFacebook,
                        shareTwitter = shareTwitter,
                        accessToken = accessToken
                )
            }.map {
                RecordConverter.convertToRecord(it)
            }.doOnSuccess {
                episodeIdCache.get(record.episodeId)?.let {
                    episodeIdCache.put(
                            record.episodeId,
                            it.toMutableList().apply {
                                set(
                                        it.indexOfFirst { it.id == record.id },
                                        record
                                )
                            }.toList()
                    )
                }
            }.subscribeOn(ioScheduler)

    override fun delete(record: Record): Completable =
            getAccessTokenService.execute().flatMap { accessToken ->
                apiClient.deleteReview(
                        id = record.id.value,
                        accessToken = accessToken
                )
            }.toCompletable().doOnComplete {
                episodeIdCache.get(record.episodeId)?.let {
                    episodeIdCache.put(
                            record.episodeId,
                            it.minus(record)
                    )
                }
            }.subscribeOn(ioScheduler)

}