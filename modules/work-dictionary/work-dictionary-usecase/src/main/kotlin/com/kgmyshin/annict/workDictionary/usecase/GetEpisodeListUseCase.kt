package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.episode.Episode
import io.reactivex.Single

interface GetEpisodeListUseCase {

    fun execute(workId: WorkId): Single<List<Episode>>

}