package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.annict.workDictionary.ui.work.SeasonBindingModel
import com.kgmyshin.common.random.RandomHelper

object SeasonViewModelFactory {
    fun create(name: String = RandomHelper.randomString(), identifierName: String = RandomHelper.randomString()): SeasonBindingModel = SeasonBindingModel(name, identifierName)
}
