package com.kgmyshin.workDictionary

import com.kgmyshin.auth.hostService.AuthHostServiceModule
import com.kgmyshin.common.di.Component
import com.kgmyshin.workDictionary.ui.work.popular.*
import com.kgmyshin.workDictionary.ui.work.season.BeforeSeasonWorkListContract
import com.kgmyshin.workDictionary.ui.work.season.NextSeasonWorkListContract
import com.kgmyshin.workDictionary.ui.work.season.ThisSeasonWorkListContract
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

    fun inject(fragment: PopularWorkListFragment)

    fun inject(fragment: BeforeSeasonWorkListFragment)

    fun inject(fragment: ThisSeasonWorkListFragment)

    fun inject(fragment: NextSeasonWorkListFragment)

}