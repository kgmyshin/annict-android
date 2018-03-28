package com.kgmyshin.annict.workDictionary.ui.work.search

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress
import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel

interface SearchWorkListContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition
        )

        fun onUpdateKeyword(keyword: String)

        fun onAttach()

        fun onDetach()

        fun onClickWork(workBindingModel: WorkBindingModel)
    }

    interface View : BaseView, HasProgress {

        fun setUp(bindingModelList: List<WorkBindingModel>)

    }

}