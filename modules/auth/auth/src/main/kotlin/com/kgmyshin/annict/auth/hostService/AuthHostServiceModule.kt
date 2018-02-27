package com.kgmyshin.annict.auth.hostService

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AuthHostServiceModule(application: Application) {

    private val component = DaggerAuthHostServiceInternalComponent.builder()
            .authHostServiceInternalModule(AuthHostServiceInternalModule(application))
            .build()

    @Provides
    fun provideExistsAccessTokenService(): ExistsAccessTokenService = component.existsAccessTokenService()

    @Provides
    fun provideGetAccessTokenService(): GetAccessTokenService = component.getAccessTokenService()

}