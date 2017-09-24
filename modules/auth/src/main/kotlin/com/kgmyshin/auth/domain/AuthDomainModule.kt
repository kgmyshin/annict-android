package com.kgmyshin.auth.domain

import com.kgmyshin.auth.domain.impl.AccessTokenRepositoryImpl
import com.kgmyshin.auth.domain.impl.AuthorizeServiceImpl
import com.kgmyshin.auth.infra.localStore.AccessTokenLocalStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AuthDomainModule {

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