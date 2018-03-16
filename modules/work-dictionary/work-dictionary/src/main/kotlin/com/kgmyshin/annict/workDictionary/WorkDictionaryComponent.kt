package com.kgmyshin.annict.workDictionary

import com.kgmyshin.annict.auth.hostService.AuthHostServiceModule
import com.kgmyshin.common.di.Component
import com.kgmyshin.annict.workDictionary.ui.work.detail.WorkDetailContract
import com.kgmyshin.annict.workDictionary.ui.work.popular.*
import com.kgmyshin.annict.workDictionary.ui.work.search.SearchWorkListFragment
import com.kgmyshin.annict.workDictionary.ui.work.season.*
import javax.inject.Singleton

@Singleton
@dagger.Component(modules = arrayOf(
        WorkDictionaryModule::class,
        AuthHostServiceModule::class
))
interface WorkDictionaryComponent : Component {

    fun beforeSeasonWorkListContract_Presenter(): BeforeSeasonWorkListContract.Presenter

    fun nextSeasonWorkListContract_Presenter(): NextSeasonWorkListContract.Presenter

    fun thisSeasonWorkListContract_Presenter(): ThisSeasonWorkListContract.Presenter

    fun popularWorkListContract_Presenter(): PopularWorkListContract.Presenter

    fun workDetailContract_Presenter(): WorkDetailContract.Presenter

    fun inject(fragment: PopularWorkListFragment)

    fun inject(fragment: BeforeSeasonWorkListFragment)

    fun inject(fragment: ThisSeasonWorkListFragment)

    fun inject(fragment: NextSeasonWorkListFragment)

    fun inject(fragment: SearchWorkListFragment)

}