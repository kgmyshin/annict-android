package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.GetPopularWorksUseCase
import io.reactivex.Single

internal class GetPopularWorksUseCaseImpl(private val repository: WorkRepository) : GetPopularWorksUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllPopular()

}