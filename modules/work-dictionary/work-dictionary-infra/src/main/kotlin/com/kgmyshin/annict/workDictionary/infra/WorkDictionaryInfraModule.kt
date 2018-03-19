package com.kgmyshin.annict.workDictionary.infra

import com.kgmyshin.annict.workDictionary.domain.work.WorkRepository
import com.kgmyshin.annict.workDictionary.domain.work.episode.EpisodeRepository
import com.kgmyshin.annict.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.annict.workDictionary.infra.api.WorkDictionaryApiClientFactory
import com.kgmyshin.annict.workDictionary.infra.domain.work.WorkRepositoryImpl
import com.kgmyshin.annict.workDictionary.infra.domain.work.episode.EpisodeRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkDictionaryInfraModule {

    @Provides
    fun provideWorkDictionaryApiClient(): WorkDictionaryApiClient =
            WorkDictionaryApiClientFactory().create()

    @Singleton
    @Provides
    internal fun provideWorkRepository(
            impl: WorkRepositoryImpl
    ): WorkRepository = impl

    @Singleton
    @Provides
    internal fun provideEpisodeRepository(
            impl: EpisodeRepositoryImpl
    ): EpisodeRepository = impl

}