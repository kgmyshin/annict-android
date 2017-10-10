package com.kgmyshin.workDictionary.ui.work.season

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkListContract
import com.kgmyshin.workDictionary.ui.work.WorkViewModel
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter
import com.kgmyshin.workDictionary.usecase.GetBeforeSeasonWorkListUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.inject.Named

internal class BeforeSeasonWorkListPresenter @Inject constructor(
        private val getBeforeSeasonWorkListUseCase: GetBeforeSeasonWorkListUseCase,
        @Named("ui") private val uiSchduler: Scheduler,
        private val errorHandler: ErrorHandler
) : WorkListContract.Presenter {

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
                .doOnSubscribe {
                    view.showProgress()
                }
                .observeOn(uiSchduler)
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

    override fun onClickWork(workViewModel: WorkViewModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}