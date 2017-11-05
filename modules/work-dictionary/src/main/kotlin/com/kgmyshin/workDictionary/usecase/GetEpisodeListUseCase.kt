package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.Episode
import io.reactivex.Single

internal interface GetEpisodeListUseCase {

    fun execute(workId: WorkId): Single<List<Episode>>

}