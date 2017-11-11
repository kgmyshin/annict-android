package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetWorkUseCase
import io.reactivex.Maybe

internal class GetWorkUseCaseImpl(private val repository: WorkRepository) : GetWorkUseCase {

    override fun execute(id: WorkId): Maybe<Work> = repository.findById(id)

}