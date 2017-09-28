package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import io.reactivex.Maybe
import io.reactivex.Single

internal interface GetWorkUseCase {

    fun execute(id: WorkId): Maybe<Work>

}