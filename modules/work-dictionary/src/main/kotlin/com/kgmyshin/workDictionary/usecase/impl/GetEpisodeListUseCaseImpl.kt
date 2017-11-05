package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.Episode
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeRepository
import com.kgmyshin.workDictionary.usecase.GetEpisodeListUseCase
import io.reactivex.Single

internal class GetEpisodeListUseCaseImpl(private val repository: EpisodeRepository) : GetEpisodeListUseCase {

    override fun execute(workId: WorkId): Single<List<Episode>> = repository.findAllByWorkId(workId)
}