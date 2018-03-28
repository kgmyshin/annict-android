package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.annict.workDictionary.ui.work.SeasonBindingModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel
import com.kgmyshin.common.random.RandomHelper

object WorkViewModelFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            title: String = RandomHelper.randomString(),
            titleKana: String = RandomHelper.randomString(),
            season: SeasonBindingModel = com.kgmyshin.workDictionary.ui.work.SeasonViewModelFactory.create(),
            officialSiteUrl: String = RandomHelper.randomString(),
            twitterUserName: String = RandomHelper.randomString(),
            imageUrl: String = RandomHelper.randomString(),
            episodesCount: Int = RandomHelper.randomInt(),
            watchersCount: Int = RandomHelper.randomInt()
    ): WorkBindingModel = WorkBindingModel(id, title, titleKana, season, officialSiteUrl, twitterUserName, imageUrl, episodesCount, watchersCount)
}
