package com.kgmyshin.workDictionary

import android.app.Application
import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.workDictionary.domain.work.WorkDictionaryDomainModule
import com.kgmyshin.workDictionary.infra.WorkDictionaryInfraModule
import com.kgmyshin.workDictionary.ui.ErrorHandlerImpl
import com.kgmyshin.workDictionary.ui.WorkDictionaryUiModule
import com.kgmyshin.workDictionary.usecase.WorkDictionaryUseCaseModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module(includes = arrayOf(
        WorkDictionaryInfraModule::class,
        WorkDictionaryDomainModule::class,
        WorkDictionaryUseCaseModule::class,
        WorkDictionaryUiModule::class
))
class WorkDictionaryModule(private val application: Application) {

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