package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.usecase.GetEpisodeListUseCase
import com.kgmyshin.workDictionary.usecase.GetWorkUseCase
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.zipWith
import javax.inject.Inject
import javax.inject.Named

internal class WorkDetailPresenter @Inject constructor(
        private val getWorkUseCase: GetWorkUseCase,
        private val getEpisodeListUseCase: GetEpisodeListUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : WorkDetailContract.Presenter {

    private lateinit var view: WorkDetailContract.View
    private lateinit var screenTransition: ScreenTransition
    private lateinit var workId: WorkId
    private val disposables = CompositeDisposable()

    override fun setUp(
            view: WorkDetailContract.View,
            screenTransition: ScreenTransition,
            workId: String
    ) {
        this.view = view
        this.screenTransition = screenTransition
        this.workId = WorkId(workId)
    }

    override fun onCreateView() {
        getWorkUseCase.execute(workId)
                .toSingle()
                .zipWith(
                        getEpisodeListUseCase.execute(workId)
                )
                .observeOn(uiScheduler)
                .doOnSubscribe { view.showProgress() }
                .subscribe({ pair ->
                               view.setUp(WorkDetailViewModelConverter.convertToViewModel(
                                       pair.first,
                                       pair.second
                               ))
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