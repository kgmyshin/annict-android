package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.annict.workDictionary.ui.work.SeasonViewModel
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel
import com.kgmyshin.random.RandomHelper

object WorkViewModelFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            title: String = RandomHelper.randomString(),
            titleKana: String = RandomHelper.randomString(),
            season: SeasonViewModel = com.kgmyshin.workDictionary.ui.work.SeasonViewModelFactory.create(),
            officialSiteUrl: String = RandomHelper.randomString(),
            twitterUserName: String = RandomHelper.randomString(),
            imageUrl: String = RandomHelper.randomString(),
            episodesCount: Int = RandomHelper.randomInt(),
            watchersCount: Int = RandomHelper.randomInt()
    ): WorkViewModel = WorkViewModel(id, title, titleKana, season, officialSiteUrl, twitterUserName, imageUrl, episodesCount, watchersCount)
}
