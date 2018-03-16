package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.random.RandomHelper
import kotlin.String

object SeasonViewModelFactory {
  fun create(name: String = RandomHelper.randomString(), identifierName: String = RandomHelper.randomString()): SeasonViewModel = com.kgmyshin.workDictionary.ui.work.SeasonViewModel(name, identifierName)
}
