package com.kgmyshin.annict.auth.ui

import com.kgmyshin.annict.auth.ui.login.LoginContract
import com.kgmyshin.annict.auth.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class AuthUiModule {

    @Provides
    fun provide_LoginContract_Presenter(
            loginPresenter: LoginPresenter
    ): LoginContract.Presenter = loginPresenter

}