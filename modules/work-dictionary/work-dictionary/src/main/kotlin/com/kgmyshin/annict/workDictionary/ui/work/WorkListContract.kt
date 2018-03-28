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

        fun onClickWork(workBindingModel: WorkBindingModel)

    }

    interface View : BaseView, HasProgress {

        fun setUp(bindingModelList: List<WorkBindingModel>)

    }

}