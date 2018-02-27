package com.kgmyshin.annict.auth.hostservice

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AuthHostServiceInternalModule::class))
internal interface AuthHostServiceInternalComponent {

    fun existsAccessTokenService(): ExistsAccessTokenService

    fun getAccessTokenService(): GetAccessTokenService

}