package com.kgmyshin.workDictionary.ui.work

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

    }

    interface View : BaseView, HasProgress {

        fun setUp(viewModelList: List<WorkViewModel>)

    }

}