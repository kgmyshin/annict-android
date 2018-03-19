package com.kgmyshin.workDictionary.ui.work.season

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.annict.workDictionary.ui.work.season.BeforeSeasonWorkListPresenter
import com.kgmyshin.annict.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
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
internal class BeforeSeasonWorkListPresenterSpec : SubjectSpek<BeforeSeasonWorkListPresenter>({

    val getBeforeSeasonWorkListUseCase = Mockito.mock(GetBeforeSeasonWorkListUseCase::class.java)
    val errorHandler = Mockito.mock(ErrorHandler::class.java)
    val view = Mockito.mock(WorkListContract.View::class.java)
    val screenTransition = Mockito.mock(ScreenTransition::class.java)

    subject {
        BeforeSeasonWorkListPresenter(
                getBeforeSeasonWorkListUseCase,
                Schedulers.trampoline(),
                errorHandler
        ).apply {
            setUp(
                    view,
                    screenTransition
            )
        }
    }

    given("GetBeforeSeasonWorkListUseCase return workList") {

        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )

        beforeGroup {
            Mockito.`when`(getBeforeSeasonWorkListUseCase.execute()).thenReturn(Single.just(workList))
        }

        on("onCreateView") {

            subject.onCreateView()

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