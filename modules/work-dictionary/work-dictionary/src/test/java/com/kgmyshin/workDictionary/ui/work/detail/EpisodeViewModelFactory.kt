package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.random.RandomHelper
import kotlin.Int
import kotlin.String

object EpisodeViewModelFactory {
  fun create(number: Int = RandomHelper.randomInt(), title: String = RandomHelper.randomString()): EpisodeViewModel = com.kgmyshin.workDictionary.ui.work.detail.EpisodeViewModel(number, title)
}
