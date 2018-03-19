package com.kgmyshin.annict.workDictionary.usecase.impl

import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.usecase.SearchWorkListUseCase
import io.reactivex.Single
import javax.inject.Inject

internal class SearchWorkListUseCaseImpl @Inject constructor(
        private val repository: WorkRepository
) : SearchWorkListUseCase {

    override fun execute(keyword: String): Single<List<Work>> = repository.findAllByKeyword(keyword)

}