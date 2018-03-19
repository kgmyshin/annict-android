package com.kgmyshin.annict.workDictionary.ui.work

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress

interface WorkListContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition
        )

        fun onCreateView()

        fun onAttach()

        fun onDetach()

        fun onClickWork(workViewModel: WorkViewModel)

    }

    interface View : BaseView, HasProgress {

        fun setUp(viewModelList: List<WorkViewModel>)

    }

}