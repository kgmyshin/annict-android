package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import io.reactivex.Single

internal class GetBeforeSeasonWorkListUseCaseImpl(private val repository: WorkRepository) : GetBeforeSeasonWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.beforeSeason())
}