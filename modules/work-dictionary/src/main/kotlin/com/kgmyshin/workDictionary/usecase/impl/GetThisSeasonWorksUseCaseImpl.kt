package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetThisSeasonWorksUseCase
import io.reactivex.Single

internal class GetThisSeasonWorksUseCaseImpl(private val repository: WorkRepository) : GetThisSeasonWorksUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllBySeason(Season.thisSeason())

}