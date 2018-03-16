package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.episode.Episode
import com.kgmyshin.annict.workDictionary.domain.work.episode.EpisodeRepository
import com.kgmyshin.annict.workDictionary.usecase.GetEpisodeListUseCase
import io.reactivex.Single
import javax.inject.Inject

internal class GetEpisodeListUseCaseImpl @Inject constructor(
        private val repository: EpisodeRepository
) : GetEpisodeListUseCase {

    override fun execute(workId: WorkId): Single<List<Episode>> = repository.findAllByWorkId(workId)
}