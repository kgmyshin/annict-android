package com.kgmyshin.workDictionary.domain.work

import io.reactivex.Maybe
import io.reactivex.Single

internal interface WorkRepository {

    fun findById(id: WorkId): Maybe<Work>

    fun findAllByKeyword(keyword: String): Single<List<Work>>

    fun findAllBySeason(season: Season): Single<List<Work>>

    fun findAllPopular(): Single<List<Work>>

}