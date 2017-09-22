package com.kgmyshin.auth.ui

import com.kgmyshin.auth.ui.login.LoginContract
import com.kgmyshin.auth.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class AuthUiModule {

    @Provides
    fun provide_LoginContract_Presenter(): LoginContract.Presenter = LoginPresenter()

}