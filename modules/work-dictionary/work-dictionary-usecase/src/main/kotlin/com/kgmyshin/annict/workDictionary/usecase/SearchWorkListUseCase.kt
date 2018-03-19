package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.domain.work.Work
import io.reactivex.Single

interface SearchWorkListUseCase {

    fun execute(keyword: String): Single<List<Work>>

}