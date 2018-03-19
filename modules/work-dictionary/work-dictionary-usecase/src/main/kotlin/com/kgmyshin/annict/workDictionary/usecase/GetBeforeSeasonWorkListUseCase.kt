package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.domain.work.Work
import io.reactivex.Single

interface GetBeforeSeasonWorkListUseCase {

    fun execute(): Single<List<Work>>

}