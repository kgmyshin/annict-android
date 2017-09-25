package com.kgmyshin.auth

import android.app.Application
import com.kgmyshin.auth.domain.AuthDomainModule
import com.kgmyshin.auth.infra.AuthInfraModule
import com.kgmyshin.auth.ui.AuthUiModule
import com.kgmyshin.auth.ui.ErrorHandlerImpl
import com.kgmyshin.auth.usecase.AuthUseCaseModule
import com.kgmyshin.common.errorHandler.ErrorHandler
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module(includes = arrayOf(
        AuthInfraModule::class,
        AuthDomainModule::class,
        AuthUseCaseModule::class,
        AuthUiModule::class
))
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