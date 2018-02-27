package com.kgmyshin.annict.auth.ui.login

import com.kgmyshin.common.view.BaseView
import com.kgmyshin.common.view.HasProgress

interface LoginContract {

    interface Presenter {

        fun setUp(
                view: View,
                screenTransition: ScreenTransition
        )

        fun onCreateView()

        fun onLoaded(url: String)

        fun onAttach()

        fun onDetach()

    }

    interface View : BaseView, HasProgress {

        fun load(url: String)

    }

}