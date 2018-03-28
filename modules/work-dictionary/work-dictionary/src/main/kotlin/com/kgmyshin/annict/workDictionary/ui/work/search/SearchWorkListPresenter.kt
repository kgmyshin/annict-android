package com.kgmyshin.annict.workDictionary.ui.work.search

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModelConverter
import com.kgmyshin.annict.workDictionary.usecase.SearchWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
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
    private val disposables = CompositeDisposable()

    override fun setUp(
            view: SearchWorkListContract.View,
            screenTransition: ScreenTransition
    ) {
        this.view = view
        this.screenTransition = screenTransition
    }

    override fun onAttach() {
    }

    override fun onDetach() {
        disposables.clear()
    }

    override fun onUpdateKeyword(keyword: String) {
        searchWorkListUseCase.execute(keyword)
                .doOnSubscribe {
                    view.showProgress()
                }
                .observeOn(uiScheduler)
                .subscribe({ workList ->
                    view.setUp(WorkBindingModelConverter.convertToViewModel(workList))
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

    override fun onClickWork(workBindingModel: WorkBindingModel) = screenTransition.moveToDetail()
}