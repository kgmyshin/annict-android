package com.kgmyshin.annict.workDictionary.ui.work.detail

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress

interface WorkDetailContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition,
                workId: String
        )

        fun onCreateView()

        fun onAttach()

        fun onDetach()

    }

    interface View : BaseView, HasProgress {

        fun setUp(workDetailViewModel: WorkDetailViewModel)

    }

}