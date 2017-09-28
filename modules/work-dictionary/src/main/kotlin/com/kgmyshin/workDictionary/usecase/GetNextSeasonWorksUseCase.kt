package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.Work
import io.reactivex.Single

internal interface GetNextSeasonWorksUseCase {

    fun execute(): Single<List<Work>>

}