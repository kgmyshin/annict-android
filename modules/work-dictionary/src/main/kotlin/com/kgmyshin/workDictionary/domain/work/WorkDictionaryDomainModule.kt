package com.kgmyshin.workDictionary.domain.work

import com.kgmyshin.workDictionary.domain.work.episode.EpisodeRepository
import com.kgmyshin.workDictionary.domain.work.impl.WorkRepositoryImpl
import com.kgmyshin.workDictionary.domain.work.impl.episode.EpisodeRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
internal class WorkDictionaryDomainModule {

    @Provides
    fun provideWorkRepository(
            workRepositoryImpl: WorkRepositoryImpl
    ): WorkRepository = workRepositoryImpl


    @Provides
    fun provideEpisodeRepository(
            episodeRepositoryImpl: EpisodeRepositoryImpl
    ): EpisodeRepository = episodeRepositoryImpl

}