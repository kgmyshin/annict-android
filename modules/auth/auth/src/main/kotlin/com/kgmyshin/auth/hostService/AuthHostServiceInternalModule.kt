package com.kgmyshin.auth.hostService

import android.app.Application
import com.kgmyshin.auth.domain.AuthDomainModule
import com.kgmyshin.auth.hostService.impl.ExistsAccessTokenServiceImpl
import com.kgmyshin.auth.hostService.impl.GetAccessTokenServiceImpl
import com.kgmyshin.auth.infra.AuthInfraModule
import com.kgmyshin.auth.usecase.AuthUseCaseModule
import com.kgmyshin.auth.usecase.ExistsAccessTokenUseCase
import com.kgmyshin.auth.usecase.GetAccessTokenUseCase
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(
        AuthUseCaseModule::class,
        AuthDomainModule::class,
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