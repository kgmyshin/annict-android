package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.usecase.GetWorkUseCase
import io.reactivex.Maybe
import javax.inject.Inject

internal class GetWorkUseCaseImpl @Inject constructor(
        private val repository: WorkRepository
) : GetWorkUseCase {

    override fun execute(id: WorkId): Maybe<Work> = repository.findById(id)

}