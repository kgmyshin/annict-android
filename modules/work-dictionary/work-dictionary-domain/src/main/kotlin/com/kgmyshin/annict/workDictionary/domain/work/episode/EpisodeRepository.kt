package com.kgmyshin.annict.workDictionary.domain.work.episode

import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import io.reactivex.Maybe
import io.reactivex.Single

interface EpisodeRepository {

    fun findById(id: EpisodeId): Maybe<Episode>

    fun findAllByWorkId(workId: WorkId): Single<List<Episode>>

}