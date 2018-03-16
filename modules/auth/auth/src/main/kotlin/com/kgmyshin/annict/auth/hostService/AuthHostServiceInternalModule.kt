package com.kgmyshin.annict.auth.hostService

import android.app.Application
import com.kgmyshin.annict.auth.hostService.impl.ExistsAccessTokenServiceImpl
import com.kgmyshin.annict.auth.hostService.impl.GetAccessTokenServiceImpl
import com.kgmyshin.annict.auth.infra.AuthInfraModule
import com.kgmyshin.annict.auth.usecase.AuthUseCaseModule
import com.kgmyshin.annict.auth.usecase.ExistsAccessTokenUseCase
import com.kgmyshin.annict.auth.usecase.GetAccessTokenUseCase
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(
        AuthUseCaseModule::class,
        AuthInfraModule::class
))
internal class AuthHostServiceInternalModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application

    @Provides
    fun provideExistsAccessTokenService(
            useCase: ExistsAccessTokenUseCase
    ): ExistsAccessTokenService = ExistsAccessTokenServiceImpl(useCase)

    @Provides
    fun provideGetAccessTokenService(
            useCase: GetAccessTokenUseCase
    ): GetAccessTokenService = GetAccessTokenServiceImpl(useCase)
}