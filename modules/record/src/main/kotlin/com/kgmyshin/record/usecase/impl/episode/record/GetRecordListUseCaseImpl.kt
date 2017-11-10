package com.kgmyshin.record.usecase.impl.episode.record

import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.Record
import com.kgmyshin.record.domain.episode.record.RecordRepository
import com.kgmyshin.record.usecase.episode.record.GetRecordListUseCase
import io.reactivex.Single

internal class GetRecordListUseCaseImpl(private val repository: RecordRepository) : GetRecordListUseCase {

    override fun execute(episodeId: EpisodeId): Single<List<Record>> = repository.findByEpisodeId(episodeId)

}