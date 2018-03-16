package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.Season
import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.usecase.GetThisSeasonWorkListUseCase
import io.reactivex.Single
import javax.inject.Inject

internal class GetThisSeasonWorkListUseCaseImpl @Inject constructor(
        private val repository: WorkRepository
) : GetThisSeasonWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.thisSeason())

}