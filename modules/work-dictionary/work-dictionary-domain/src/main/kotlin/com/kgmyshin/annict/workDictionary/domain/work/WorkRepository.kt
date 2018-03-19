package com.kgmyshin.annict.workDictionary.domain.work

import io.reactivex.Maybe
import io.reactivex.Single

interface WorkRepository {

    fun findById(id: WorkId): Maybe<Work>

    fun findAllByKeyword(keyword: String): Single<List<Work>>

    fun findAllBySeason(season: Season): Single<List<Work>>

    fun findAllPopular(): Single<List<Work>>

}