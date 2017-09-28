package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.Work
import io.reactivex.Single

internal interface GetThisSeasonWorksUseCase {

    fun execute(): Single<List<Work>>

}