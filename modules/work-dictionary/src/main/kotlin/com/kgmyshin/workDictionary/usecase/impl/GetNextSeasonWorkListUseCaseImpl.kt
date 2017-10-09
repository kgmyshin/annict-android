package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetNextSeasonWorkListUseCase
import io.reactivex.Single

internal class GetNextSeasonWorkListUseCaseImpl(private val repository: WorkRepository) : GetNextSeasonWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.nextSeason())

}