package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.usecase.GetEpisodeListUseCase
import com.kgmyshin.workDictionary.usecase.GetWorkUseCase
import io.reactivex.Maybe
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
internal class WorkDetailPresenterSpec : SubjectSpek<WorkDetailPresenter>({

    val getWorkUseCase = Mockito.mock(GetWorkUseCase::class.java)
    val getEpisodeListUseCase = Mockito.mock(GetEpisodeListUseCase::class.java)
    val errorHandler = Mockito.mock(ErrorHandler::class.java)
    val view = Mockito.mock(WorkDetailContract.View::class.java)
    val screenTransition = Mockito.mock(ScreenTransition::class.java)
    val rawWorkId = RandomHelper.randomString()
    val workId = WorkId(rawWorkId)

    subject {
        WorkDetailPresenter(
                getWorkUseCase,
                getEpisodeListUseCase,
                Schedulers.trampoline(),
                errorHandler
        ).apply {
            setUp(
                    view,
                    screenTransition,
                    rawWorkId
            )
        }
    }


    given("GetWorkUseCase return work and GetEpisodeListUseCase return episodeList") {

        val work = DomainHelper.work()
        val episodeList = listOf(
                DomainHelper.episode(),
                DomainHelper.episode(),
                DomainHelper.episode()
        )
        Mockito.`when`(getWorkUseCase.execute(workId)).thenReturn(Maybe.just(work))
        Mockito.`when`(getEpisodeListUseCase.execute(workId)).thenReturn(Single.just(episodeList))


        on("onCreateView") {
            subject.onCreateView()

            it("should setUp ViewModel to view") {
                val expected = WorkDetailViewModelConverter.convertToViewModel(
                        work,
                        episodeList
                )
                Mockito.verify(view).showProgress()
                Mockito.verify(view).setUp(expected)
                Mockito.verify(view).dismissProgress()
            }

        }
    }
})