package com.kgmyshin.annict.workDictionary.ui.work.season

import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModelConverter
import com.kgmyshin.annict.workDictionary.usecase.GetNextSeasonWorkListUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

internal class NextSeasonWorkListPresenter @Inject constructor(
        private val getNextSeasonWorkListUseCase: GetNextSeasonWorkListUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : NextSeasonWorkListContract.Presenter {

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
        getNextSeasonWorkListUseCase.execute()
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

    override fun onAttach() {
    }

    override fun onDetach() {
        disposables.clear()
    }

    override fun onClickWork(workBindingModel: WorkBindingModel) = screenTransition.moveToDetail()
}