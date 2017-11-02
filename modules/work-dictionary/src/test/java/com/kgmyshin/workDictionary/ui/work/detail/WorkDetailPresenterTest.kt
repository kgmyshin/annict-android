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
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class WorkDetailPresenterTest {

    @Mock
    private lateinit var getWorkUseCase: GetWorkUseCase
    @Mock
    private lateinit var getEpisodeListUseCase: GetEpisodeListUseCase
    @Mock
    private lateinit var errorHandler: ErrorHandler

    @Mock
    private lateinit var view: WorkDetailContract.View
    @Mock
    private lateinit var screenTransition: ScreenTransition

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testOnCreateView() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val work = DomainHelper.work()
        val episodeList = listOf(
                DomainHelper.episode(),
                DomainHelper.episode(),
                DomainHelper.episode()
        )
        Mockito.`when`(getWorkUseCase.execute(workId)).thenReturn(Maybe.just(work))
        Mockito.`when`(getEpisodeListUseCase.execute(workId)).thenReturn(Single.just(episodeList))

        // when
        val presenter = WorkDetailPresenter(
                getWorkUseCase,
                getEpisodeListUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition,
                workId.value
        )
        presenter.onCreateView()

        // test
        val expected = WorkDetailViewModelConverter.convertToViewModel(
                work,
                episodeList
        )
        Mockito.verify(view).showProgress()
        Mockito.verify(view).setUp(expected)
        Mockito.verify(view).dismissProgress()
    }


}