package com.kgmyshin.auth

import com.kgmyshin.auth.ui.AuthUiModule
import dagger.Module

@Module(includes = arrayOf(
        AuthUiModule::class
))
class AuthModule {
}