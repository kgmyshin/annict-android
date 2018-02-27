package com.kgmyshin.auth.usecase

import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.domain.AuthorizeService
import com.kgmyshin.auth.usecase.impl.AuthorizeUseCaseImpl
import com.kgmyshin.auth.usecase.impl.ExistsAccessTokenUseCaseImpl
import com.kgmyshin.auth.usecase.impl.GetAccessTokenUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
internal class AuthUseCaseModule {

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