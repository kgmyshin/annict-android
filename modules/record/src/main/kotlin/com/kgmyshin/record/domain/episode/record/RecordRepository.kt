package com.kgmyshin.record.domain.episode.record

import com.kgmyshin.record.domain.episode.EpisodeId
import io.reactivex.Completable
import io.reactivex.Single

internal interface RecordRepository {

    fun findByEpisodeId(episodeId: EpisodeId): Single<List<Record>>

    fun create(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Record>

    fun update(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Record>

    fun delete(record: Record): Completable

}