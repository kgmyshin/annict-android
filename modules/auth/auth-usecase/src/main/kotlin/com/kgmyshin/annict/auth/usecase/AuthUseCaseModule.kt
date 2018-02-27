package com.kgmyshin.annict.auth.usecase

import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import com.kgmyshin.annict.auth.domain.AuthorizeService
import com.kgmyshin.annict.auth.usecase.impl.AuthorizeUseCaseImpl
import com.kgmyshin.annict.auth.usecase.impl.ExistsAccessTokenUseCaseImpl
import com.kgmyshin.annict.auth.usecase.impl.GetAccessTokenUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class AuthUseCaseModule {

    @Provides
    fun provideAuthorizeUseCase(
            authorizeService: AuthorizeService,
            accessTokenRepository: AccessTokenRepository
    ): AuthorizeUseCase = AuthorizeUseCaseImpl(
            authorizeService,
            accessTokenRepository
    )

    @Provides
    fun provideGetAccessTokenUseCase(
            accessTokenRepository: AccessTokenRepository
    ): GetAccessTokenUseCase = GetAccessTokenUseCaseImpl(
            accessTokenRepository
    )

    @Provides
    fun provideExistsAccessTokenUseCase(
            accessTokenRepository: AccessTokenRepository
    ): ExistsAccessTokenUseCase = ExistsAccessTokenUseCaseImpl(
            accessTokenRepository
    )

}