package com.kgmyshin.annict.auth.infra

import android.app.Application
import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.domain.AuthorizeService
import com.kgmyshin.annict.auth.infra.api.AuthApiClient
import com.kgmyshin.annict.auth.infra.api.AuthApiClientFactory
import com.kgmyshin.annict.auth.infra.domain.AccessTokenRepositoryImpl
import com.kgmyshin.annict.auth.infra.domain.AuthorizeServiceImpl
import com.kgmyshin.annict.auth.infra.localStore.AccessTokenLocalStore
import com.kgmyshin.annict.auth.infra.localStore.impl.AccessTokenLocalStoreImpl
import com.kgmyshin.annict.auth.infra.pref.AccessTokenPreference
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthInfraModule {

    @Provides
    fun provideAccessTokenLocalStore(application: Application): AccessTokenLocalStore =
            AccessTokenLocalStoreImpl(AccessTokenPreference(application))

    @Provides
    fun provideAuthApiClient(): AuthApiClient = AuthApiClientFactory().create()

    @Provides
    fun provideAuthorizeService(
            authorizeServiceImpl: AuthorizeServiceImpl
    ): AuthorizeService = authorizeServiceImpl

    @Singleton
    @Provides
    fun provideAccessTokenRepository(
            accessTokenLocalStore: AccessTokenLocalStore
    ): AccessTokenRepository = AccessTokenRepositoryImpl(accessTokenLocalStore)

}