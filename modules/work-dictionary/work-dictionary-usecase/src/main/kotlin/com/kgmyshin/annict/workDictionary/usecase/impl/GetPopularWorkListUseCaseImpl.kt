package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.usecase.GetPopularWorkListUseCase
import io.reactivex.Single
import javax.inject.Inject

internal class GetPopularWorkListUseCaseImpl @Inject constructor(
        private val repository: WorkRepository
) : GetPopularWorkListUseCase {

    override fun execute(): Single<List<Work>> = repository.findAllPopular()

}