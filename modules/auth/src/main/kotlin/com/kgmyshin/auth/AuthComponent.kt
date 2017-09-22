package com.kgmyshin.auth

import com.kgmyshin.auth.ui.login.LoginContract
import com.kgmyshin.auth.ui.login.LoginFragment
import com.kgmyshin.common.di.Component
import javax.inject.Singleton

@Singleton
@dagger.Component(modules = arrayOf(
        AuthModule::class
))
interface AuthComponent : Component {

    fun loginContract_Presenter(): LoginContract.Presenter

    fun inject(fragment: LoginFragment)

}