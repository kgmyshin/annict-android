package com.kgmyshin.auth.ui.login

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

    interface View {

        fun load(url: String)

    }

    interface ScreenTransition {

        fun moveToHome()

    }

}