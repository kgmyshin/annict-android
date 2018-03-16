package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.random.RandomHelper
import kotlin.Int
import kotlin.String

object WorkViewModelFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      title: String = RandomHelper.randomString(),
      titleKana: String = RandomHelper.randomString(),
      season: com.kgmyshin.workDictionary.ui.work.SeasonViewModel = com.kgmyshin.workDictionary.ui.work.SeasonViewModelFactory.create(),
      officialSiteUrl: String = RandomHelper.randomString(),
      twitterUserName: String = RandomHelper.randomString(),
      imageUrl: String = RandomHelper.randomString(),
      episodesCount: Int = RandomHelper.randomInt(),
      watchersCount: Int = RandomHelper.randomInt()
  ): WorkViewModel = com.kgmyshin.workDictionary.ui.work.WorkViewModel(id, title, titleKana, season, officialSiteUrl, twitterUserName, imageUrl, episodesCount, watchersCount)
}
