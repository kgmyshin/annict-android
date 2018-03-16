package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.domain.work.Work
import io.reactivex.Single

interface GetPopularWorkListUseCase {

    fun execute(): Single<List<Work>>

}