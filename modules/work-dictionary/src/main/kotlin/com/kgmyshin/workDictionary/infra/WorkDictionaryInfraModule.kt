package com.kgmyshin.workDictionary.infra

import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClientFactory
import dagger.Module
import dagger.Provides

@Module
internal class WorkDictionaryInfraModule {

    @Provides
    fun provideWorkDictionaryApiClient(): WorkDictionaryApiClient =
            WorkDictionaryApiClientFactory().create()

}