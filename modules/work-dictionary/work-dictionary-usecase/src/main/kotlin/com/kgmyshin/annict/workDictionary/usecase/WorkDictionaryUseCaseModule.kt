package com.kgmyshin.annict.workDictionary.usecase

import com.kgmyshin.annict.workDictionary.usecase.impl.*
import dagger.Module
import dagger.Provides

@Module
class WorkDictionaryUseCaseModule {

    @Provides
    internal fun provideGetBeforeSeasonWorkListUseCase(
            impl: GetBeforeSeasonWorkListUseCaseImpl
    ): GetBeforeSeasonWorkListUseCase = impl

    @Provides
    internal fun provideGetThisSeasonWorkListUseCase(
            impl: GetThisSeasonWorkListUseCaseImpl
    ): GetThisSeasonWorkListUseCase = impl

    @Provides
    internal fun provideGetNextSeasonWorkListUseCase(
            impl: GetNextSeasonWorkListUseCaseImpl
    ): GetNextSeasonWorkListUseCase = impl

    @Provides
    internal fun provideGetPopularSeasonWorkListUseCase(
            impl: GetPopularWorkListUseCaseImpl
    ): GetPopularWorkListUseCase = impl

    @Provides
    internal fun provideGetWorkUseCase(
            impl: GetWorkUseCaseImpl
    ): GetWorkUseCase = impl

    @Provides
    internal fun provideSearchWorkListUseCase(
            impl: SearchWorkListUseCaseImpl
    ): SearchWorkListUseCase = impl

    @Provides
    internal fun provideEpisodeListUseCase(
            impl: GetEpisodeListUseCaseImpl
    ): GetEpisodeListUseCase = impl

}