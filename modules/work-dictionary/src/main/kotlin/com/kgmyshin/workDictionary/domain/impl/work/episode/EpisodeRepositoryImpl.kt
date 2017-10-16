package com.kgmyshin.workDictionary.domain.impl.work.episode

import android.support.v4.util.LruCache
import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.Episode
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeId
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeRepository
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

internal class EpisodeRepositoryImpl @Inject constructor(
        private val apiClient: WorkDictionaryApiClient,
        private val getAccessTokenService: GetAccessTokenService,
        @Named("io") private val ioScheduler: Scheduler
) : EpisodeRepository {

    private val idCache: LruCache<EpisodeId, Episode> = LruCache(1000)
    private val workIdCache: LruCache<WorkId, List<Episode>> = LruCache(100)

    override fun findById(id: EpisodeId): Maybe<Episode> =
            if (idCache.get(id) != null) {
                Maybe.just(idCache.get(id))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getEpisodeList(
                            fields = id.value,
                            accessToken = accessToken
                    )
                }.map {
                    EpisodeConverter.convertToEpisode(it.episodeJsonList[0])
                }.doOnSuccess { episode ->
                    idCache.put(
                            episode.id,
                            episode
                    )
                }.toMaybe().subscribeOn(ioScheduler)
            }

    override fun findAllByWorkId(workId: WorkId): Single<List<Episode>> =
            if (workIdCache.get(workId) != null) {
                Single.just(workIdCache.get(workId))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getEpisodeList(
                            filterWorkId = workId.value,
                            accessToken = accessToken
                    )
                }.map {
                    EpisodeConverter.convertToEpisode(it.episodeJsonList)
                }.doOnSuccess { episodeList ->
                    workIdCache.put(
                            workId,
                            episodeList
                    )
                    episodeList.forEach {
                        idCache.put(
                                it.id,
                                it
                        )
                    }
                }.subscribeOn(ioScheduler)
            }

}