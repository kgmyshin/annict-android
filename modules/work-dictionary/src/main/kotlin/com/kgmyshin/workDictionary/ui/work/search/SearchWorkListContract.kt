package com.kgmyshin.workDictionary.ui.work.search

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress
import com.kgmyshin.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.workDictionary.ui.work.WorkViewModel

interface SearchWorkListContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition,
                keyword: String
        )

        fun onCreateView()

        fun onAttach()

        fun onDetach()

    }

    interface View : BaseView, HasProgress {

        fun setUp(viewModelList: List<WorkViewModel>)

    }

}