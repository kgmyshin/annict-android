package com.kgmyshin.annict.workDictionary.ui.work.search

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress
import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel

interface SearchWorkListContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition
        )

        fun onUpdateKeyword(keyword: String)

        fun onAttach()

        fun onDetach()

        fun onClickWork(workViewModel: WorkViewModel)
    }

    interface View : BaseView, HasProgress {

        fun setUp(viewModelList: List<WorkViewModel>)

    }

}