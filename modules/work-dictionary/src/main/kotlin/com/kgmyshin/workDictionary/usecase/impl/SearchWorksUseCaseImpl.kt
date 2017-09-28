package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.SearchWorksUseCase
import io.reactivex.Single

internal class SearchWorksUseCaseImpl(private val repository: WorkRepository) : SearchWorksUseCase {

    override fun execute(keyword: String): Single<List<Work>> = repository.findAllByKeyword(keyword)

}