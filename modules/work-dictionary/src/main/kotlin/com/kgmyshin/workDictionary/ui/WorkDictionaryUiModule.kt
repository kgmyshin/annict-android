package com.kgmyshin.workDictionary.ui

import com.kgmyshin.workDictionary.ui.work.popular.PopularWorkListContract
import com.kgmyshin.workDictionary.ui.work.popular.PopularWorkListPresenter
import com.kgmyshin.workDictionary.ui.work.search.SearchWorkListContract
import com.kgmyshin.workDictionary.ui.work.search.SearchWorkListPresenter
import com.kgmyshin.workDictionary.ui.work.season.*
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

}