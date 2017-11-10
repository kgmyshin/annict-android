package com.kgmyshin.record.usecase.episode.record

import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.Record
import io.reactivex.Single

internal interface GetRecordListUseCase {

    fun execute(episodeId: EpisodeId): Single<List<Record>>

}