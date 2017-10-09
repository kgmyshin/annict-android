package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.common.view.BaseView

interface ScreenTransition {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition
        )

    }

    interface View : BaseView {

    }

}