package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetNextSeasonWorksUseCase
import io.reactivex.Single

internal class GetNextSeasonWorksUseCaseImpl(private val repository: WorkRepository) : GetNextSeasonWorksUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.nextSeason())

}