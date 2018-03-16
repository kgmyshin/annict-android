package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import io.reactivex.Maybe

interface GetWorkUseCase {

    fun execute(id: WorkId): Maybe<Work>

}