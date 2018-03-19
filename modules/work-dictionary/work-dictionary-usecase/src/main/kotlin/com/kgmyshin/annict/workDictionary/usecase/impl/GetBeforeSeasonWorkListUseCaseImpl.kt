package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.Season
import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import io.reactivex.Single
import javax.inject.Inject

internal class GetBeforeSeasonWorkListUseCaseImpl @Inject constructor(
        private val repository: WorkRepository
) : GetBeforeSeasonWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.beforeSeason())
}