package com.kgmyshin.workDictionary.usecase

import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.usecase.impl.*
import dagger.Module
import dagger.Provides

@Module
internal class WorkDictionaryUseCaseModule {

    @Provides
    fun provideGetBeforeSeasonWorkListUseCase(
            workRepository: WorkRepository
    ): GetBeforeSeasonWorkListUseCase = GetBeforeSeasonWorkListUseCaseImpl(workRepository)

    @Provides
    fun provideGetThisSeasonWorkListUseCase(
            workRepository: WorkRepository
    ): GetThisSeasonWorkListUseCase = GetThisSeasonWorkListUseCaseImpl(workRepository)

    @Provides
    fun provideGetNextSeasonWorkListUseCase(
            workRepository: WorkRepository
    ): GetNextSeasonWorkListUseCase = GetNextSeasonWorkListUseCaseImpl(workRepository)

    @Provides
    fun provideGetPopularSeasonWorkListUseCase(
            workRepository: WorkRepository
    ): GetPopularWorkListUseCase = GetPopularWorkListUseCaseImpl(workRepository)

    @Provides
    fun provideGetWorkUseCase(
            workRepository: WorkRepository
    ): GetWorkUseCase = GetWorkUseCaseImpl(workRepository)

    @Provides
    fun provideSearchWorkListUseCase(
            workRepository: WorkRepository
    ): SearchWorkListUseCase = SearchWorkListUseCaseImpl(workRepository)

}