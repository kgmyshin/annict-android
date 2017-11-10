package com.kgmyshin.workDictionary.ui.work.season

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkListContract
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.workDictionary.ui.work.WorkViewModelFactory
import com.kgmyshin.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
class BeforeSeasonWorkListPresenterTest1 : Spek({

    val getBeforeSeasonWorkListUseCase = Mockito.mock(GetBeforeSeasonWorkListUseCase::class.java)
    val errorHandler = Mockito.mock(ErrorHandler::class.java)
    val view = Mockito.mock(WorkListContract.View::class.java)
    val screenTransition = Mockito.mock(ScreenTransition::class.java)

    given("GetBeforeSeasonWorkListUseCase return workList") {

        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )
        Mockito.`when`(getBeforeSeasonWorkListUseCase.execute()).thenReturn(Single.just(workList))

        on("onCreateView") {
            val presenter = BeforeSeasonWorkListPresenter(
                    getBeforeSeasonWorkListUseCase,
                    Schedulers.trampoline(),
                    errorHandler
            )
            presenter.setUp(
                    view,
                    screenTransition
            )
            presenter.onCreateView()

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
            val presenter = BeforeSeasonWorkListPresenter(
                    getBeforeSeasonWorkListUseCase,
                    Schedulers.trampoline(),
                    errorHandler
            )
            presenter.setUp(
                    view,
                    screenTransition
            )
            presenter.onClickWork(viewModel)

            it("should move to Detail") {
                Mockito.verify(screenTransition).moveToDetail()
            }
        }
    }

})