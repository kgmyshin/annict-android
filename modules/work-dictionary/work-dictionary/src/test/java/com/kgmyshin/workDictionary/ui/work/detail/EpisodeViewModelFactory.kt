package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.annict.workDictionary.ui.work.detail.EpisodeViewModel
import com.kgmyshin.random.RandomHelper

object EpisodeViewModelFactory {
    fun create(number: Int = RandomHelper.randomInt(), title: String = RandomHelper.randomString()): EpisodeViewModel = EpisodeViewModel(number, title)
}
