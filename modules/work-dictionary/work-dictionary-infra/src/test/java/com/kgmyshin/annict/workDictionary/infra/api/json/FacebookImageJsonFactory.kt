package com.kgmyshin.annict.workDictionary.infra.api.json

import com.kgmyshin.common.random.RandomHelper

internal object FacebookImageJsonFactory {
    fun create(ogImageUrl: String = RandomHelper.randomString()): FacebookImageJson = com.kgmyshin.annict.workDictionary.infra.api.json.FacebookImageJson(ogImageUrl)
}
