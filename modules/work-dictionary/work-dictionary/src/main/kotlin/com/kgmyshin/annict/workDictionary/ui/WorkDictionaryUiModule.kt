package com.kgmyshin.annict.workDictionary.ui

import com.kgmyshin.annict.workDictionary.ui.work.detail.WorkDetailContract
import com.kgmyshin.annict.workDictionary.ui.work.detail.WorkDetailPresenter
import com.kgmyshin.annict.workDictionary.ui.work.popular.PopularWorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.popular.PopularWorkListPresenter
import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListPresenter
import com.kgmyshin.annict.workDictionary.ui.work.season.*
import dagger.Module
import dagger.Provides

@Module
internal class WorkDictionaryUiModule {

    @Provides
    fun provide_PopularWorkListContract_Presenter(
            popularWorkListPresenter: PopularWorkListPresenter
    ): PopularWorkListContract.Presenter = popularWorkListPresenter

    @Provides
    fun provide_SearchWorkListContract_Presenter(
            searchWorkListPresenter: SearchWorkListPresenter
    ): SearchWorkListContract.Presenter = searchWorkListPresenter

    @Provides
    fun provide_BeforeWorkListContract_Presenter(
            beforeSeasonWorkListPresenter: BeforeSeasonWorkListPresenter
    ): BeforeSeasonWorkListContract.Presenter = beforeSeasonWorkListPresenter

    @Provides
    fun provide_NextWorkListContract_Presenter(
            nextSeasonWorkListPresenter: NextSeasonWorkListPresenter
    ): NextSeasonWorkListContract.Presenter = nextSeasonWorkListPresenter

    @Provides
    fun provide_ThisWorkListContract_Presenter(
            thisSeasonWorkListPresenter: ThisSeasonWorkListPresenter
    ): ThisSeasonWorkListContract.Presenter = thisSeasonWorkListPresenter

    @Provides
    fun provide_WorkDetailContract_Presenter(
            workDetailPresenter: WorkDetailPresenter
    ): WorkDetailContract.Presenter = workDetailPresenter

}