package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetPopularWorkListUseCase
import io.reactivex.Single

internal class GetPopularWorkListUseCaseImpl(private val repository: WorkRepository) : GetPopularWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllPopular()

}