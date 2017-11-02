package com.kgmyshin.workDictionary.ui.work.season

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkListContract
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.workDictionary.ui.work.WorkViewModelFactory
import com.kgmyshin.workDictionary.usecase.GetNextSeasonWorkListUseCase
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextSeasonWorkListPresenterTest {

    @Mock
    private lateinit var GetNextSeasonWorkListUseCase: GetNextSeasonWorkListUseCase
    @Mock
    private lateinit var errorHandler: ErrorHandler
    @Mock
    private lateinit var view: WorkListContract.View
    @Mock
    private lateinit var screenTransition: ScreenTransition

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testOnCreateView() {
        // given
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )
        Mockito.`when`(GetNextSeasonWorkListUseCase.execute()).thenReturn(Single.just(workList))

        // when
        val presenter = NextSeasonWorkListPresenter(
                GetNextSeasonWorkListUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition
        )
        presenter.onCreateView()

        // then
        val expected = WorkViewModelConverter.convertToViewModel(workList)
        Mockito.verify(view).showProgress()
        Mockito.verify(view).setUp(expected)
        Mockito.verify(view).dismissProgress()
    }

    @Test
    fun testOnClickWork() {
        // given
        val viewModel = WorkViewModelFactory.create()

        // when
        val presenter = NextSeasonWorkListPresenter(
                GetNextSeasonWorkListUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition
        )
        presenter.onClickWork(viewModel)

        // then
        Mockito.verify(screenTransition).moveToDetail()
    }


}