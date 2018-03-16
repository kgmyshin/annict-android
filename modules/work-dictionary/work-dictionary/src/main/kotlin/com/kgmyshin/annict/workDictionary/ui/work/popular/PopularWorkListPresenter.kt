package com.kgmyshin.annict.workDictionary.ui.work.popular

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.annict.workDictionary.usecase.GetPopularWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

internal class PopularWorkListPresenter @Inject constructor(
        private val getPopularWorkListUseCase: GetPopularWorkListUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : PopularWorkListContract.Presenter {

    private lateinit var view: WorkListContract.View
    private lateinit var screenTransition: ScreenTransition
    private val disposables = CompositeDisposable()

    override fun setUp(
            view: WorkListContract.View,
            screenTransition: ScreenTransition
    ) {
        this.view = view
        this.screenTransition = screenTransition
    }

    override fun onCreateView() {
        getPopularWorkListUseCase.execute()
                .doOnSubscribe {
                    view.showProgress()
                }
                .observeOn(uiScheduler)
                .subscribe({ workList ->
                    view.setUp(WorkViewModelConverter.convertToViewModel(workList))
                    view.dismissProgress()
                }, { throwable ->
                    view.getContext()?.let {
                        errorHandler.showDialog(
                                it,
                                throwable,
                                null
                        )
                    }
                    view.dismissProgress()
                })
                .addTo(disposables)
    }

    override fun onAttach() {
    }

    override fun onDetach() {
        disposables.clear()
    }

    override fun onClickWork(workViewModel: WorkViewModel) = screenTransition.moveToDetail()
}