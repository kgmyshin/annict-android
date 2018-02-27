package com.kgmyshin.annict.auth.hostservice

import android.app.Application
import com.kgmyshin.annict.auth.hostservice.impl.ExistsAccessTokenServiceImpl
import com.kgmyshin.annict.auth.hostservice.impl.GetAccessTokenServiceImpl
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
    fun provideExistsAccessTokenService(useCase: ExistsAccessTokenUseCase): ExistsAccessTokenService = ExistsAccessTokenServiceImpl(useCase)

    @Provides
    fun provideGetAccessTokenService(useCaxe: GetAccessTokenUseCase): GetAccessTokenService = GetAccessTokenServiceImpl(useCaxe)
}