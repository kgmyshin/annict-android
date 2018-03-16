package com.kgmyshin.annict.workDictionary

import android.app.Application
import com.kgmyshin.annict.workDictionary.infra.WorkDictionaryInfraModule
import com.kgmyshin.annict.workDictionary.usecase.WorkDictionaryUseCaseModule
import com.kgmyshin.common.errorHandler.ErrorHandler
import com.kgmyshin.annict.workDictionary.ui.ErrorHandlerImpl
import com.kgmyshin.annict.workDictionary.ui.WorkDictionaryUiModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named

@Module(includes = [
    (WorkDictionaryInfraModule::class),
    (WorkDictionaryUseCaseModule::class),
    (WorkDictionaryUiModule::class)
])
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