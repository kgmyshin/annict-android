package com.kgmyshin.workDictionary.ui.work.search

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListPresenter
import com.kgmyshin.annict.workDictionary.usecase.SearchWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.ui.work.WorkViewModelFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class SearchWorkListPresenterSpec : SubjectSpek<SearchWorkListPresenter>({

    val searchWorkListUseCase = Mockito.mock(SearchWorkListUseCase::class.java)
    val errorHandler = Mockito.mock(ErrorHandler::class.java)
    val view = Mockito.mock(SearchWorkListContract.View::class.java)
    val screenTransition = Mockito.mock(ScreenTransition::class.java)

    subject {
        SearchWorkListPresenter(
                searchWorkListUseCase,
                Schedulers.trampoline(),
                errorHandler
        ).apply {
            setUp(
                    view,
                    screenTransition
            )
        }
    }

    given("SearchWorkListUseCase return workList") {
        val keyword = RandomHelper.randomString()
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )

        beforeGroup {
            Mockito.`when`(searchWorkListUseCase.execute(keyword)).thenReturn(Single.just(workList))
        }

        on("onUpdateKeyword") {
            subject.onUpdateKeyword(keyword)

            it("should setUp ViewModel to view") {
                val expected = WorkViewModelConverter.convertToViewModel(workList)
                Mockito.verify(view).showProgress()
                Mockito.verify(view).setUp(expected)
                Mockito.verify(view).dismissProgress()
            }
        }
    }

    given("") {

        on("onClickWork") {
            val viewModel = WorkViewModelFactory.create()

            subject.onClickWork(viewModel)

            it("should move to Detail") {
                Mockito.verify(screenTransition).moveToDetail()
            }
        }
    }

})