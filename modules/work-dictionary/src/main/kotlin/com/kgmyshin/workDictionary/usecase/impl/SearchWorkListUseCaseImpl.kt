package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.SearchWorkListUseCase
import io.reactivex.Single

internal class SearchWorkListUseCaseImpl(private val repository: WorkRepository) : SearchWorkListUseCase {

    override fun execute(keyword: String): Single<List<Work>> = repository.findAllByKeyword(keyword)

}