package com.kgmyshin.workDictionary.ui.work.search

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.workDictionary.usecase.SearchWorkListUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

internal class SearchWorkListPresenter @Inject constructor(
        private val searchWorkListUseCase: SearchWorkListUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : SearchWorkListContract.Presenter {

    private lateinit var view: SearchWorkListContract.View
    private lateinit var screenTransition: ScreenTransition
    private lateinit var keyword: String
    private val disposables = CompositeDisposable()

    override fun setUp(
            view: SearchWorkListContract.View,
            screenTransition: ScreenTransition,
            keyword: String
    ) {
        this.view = view
        this.screenTransition = screenTransition
        this.keyword = keyword
    }

    override fun onCreateView() {
        searchWorkListUseCase.execute(keyword)
                .doOnSubscribe {
                    view.showProgress()
                }
                .observeOn(uiScheduler)
                .subscribe({ workList ->
                               view.setUp(WorkViewModelConverter.convertToViewModel(workList))
                               view.dismissProgress()
                           },
                           { throwable ->
                               errorHandler.showDialog(
                                       view.getContext(),
                                       throwable,
                                       null
                               )
                               view.dismissProgress()
                           })
                .addTo(disposables)
    }

    override fun onAttach() {
    }

    override fun onDetach() {
        disposables.clear()
    }
}