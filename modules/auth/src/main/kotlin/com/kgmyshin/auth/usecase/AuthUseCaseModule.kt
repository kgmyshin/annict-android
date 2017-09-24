package com.kgmyshin.auth.usecase

import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.domain.AuthorizeService
import com.kgmyshin.auth.usecase.impl.AuthorizeUseCaseImpl
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

}