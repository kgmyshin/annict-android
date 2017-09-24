package com.kgmyshin.auth.hostService

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AuthHostServiceInternalModule::class))
internal interface AuthHostServiceInternalComponent {

    fun existsAccessTokenService(): ExistsAccessTokenService

    fun getAccessTokenService(): GetAccessTokenService

}