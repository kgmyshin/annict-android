package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.Work
import io.reactivex.Single

internal interface SearchWorksUseCase {

    fun execute(keyword: String): Single<List<Work>>

}