package com.kgmyshin.annict.auth

import android.app.Application
import com.kgmyshin.annict.auth.infra.AuthInfraModule
import com.kgmyshin.annict.auth.ui.AuthUiModule
import com.kgmyshin.annict.auth.ui.ErrorHandlerImpl
import com.kgmyshin.annict.auth.usecase.AuthUseCaseModule
import com.kgmyshin.common.errorHandler.ErrorHandler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module(includes = [(AuthInfraModule::class), (AuthUseCaseModule::class), (AuthUiModule::class)])
class AuthModule(private val application: Application) {

    @Provides
    fun provideApplication(): Application = application

    @Named("ui")
    @Provides
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Named("io")
    @Provides
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    @Provides
    internal fun provideErroHandler(): ErrorHandler = ErrorHandlerImpl()


}