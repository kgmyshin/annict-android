package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetThisSeasonWorkListUseCase
import io.reactivex.Single

internal class GetThisSeasonWorkListUseCaseImpl(private val repository: WorkRepository) : GetThisSeasonWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.thisSeason())

}