package com.kgmyshin.workDictionary.ui.work.season

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkListContract
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.workDictionary.ui.work.WorkViewModelFactory
import com.kgmyshin.workDictionary.usecase.GetThisSeasonWorkListUseCase
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
internal class ThisSeasonWorkListPresenterSpec : SubjectSpek<ThisSeasonWorkListPresenter>({

    val getThisSeasonWorkListUseCase = Mockito.mock(GetThisSeasonWorkListUseCase::class.java)
    val errorHandler = Mockito.mock(ErrorHandler::class.java)
    val view = Mockito.mock(WorkListContract.View::class.java)
    val screenTransition = Mockito.mock(ScreenTransition::class.java)

    subject {
        ThisSeasonWorkListPresenter(
                getThisSeasonWorkListUseCase,
                Schedulers.trampoline(),
                errorHandler
        ).apply {
            setUp(
                    view,
                    screenTransition
            )
        }
    }

    given("GetThisSeasonWorkListUseCase return workList") {

        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )

        beforeGroup {
            Mockito.`when`(getThisSeasonWorkListUseCase.execute()).thenReturn(Single.just(workList))
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