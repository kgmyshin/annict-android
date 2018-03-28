package com.kgmyshin.annict.workDictionary.ui.work.season

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModelConverter
import com.kgmyshin.annict.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

internal class BeforeSeasonWorkListPresenter @Inject constructor(
        private val getBeforeSeasonWorkListUseCase: GetBeforeSeasonWorkListUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : BeforeSeasonWorkListContract.Presenter {

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
        getBeforeSeasonWorkListUseCase.execute()
                .observeOn(uiScheduler)
                .doOnSubscribe { view.showProgress() }
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

    override fun onAttach() {
    }

    override fun onDetach() {
        disposables.clear()
    }

    override fun onClickWork(workBindingModel: WorkBindingModel) = screenTransition.moveToDetail()
}