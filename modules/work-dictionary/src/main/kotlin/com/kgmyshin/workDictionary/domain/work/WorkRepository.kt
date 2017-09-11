package com.kgmyshin.workDictionary.domain.work

import io.reactivex.Maybe
import io.reactivex.Single

internal interface WorkRepository {

    fun findAll(): Single<List<Work>>

    fun find(id: WorkId): Maybe<Work>

}