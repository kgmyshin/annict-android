package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.TwitterImageJson
import com.kgmyshin.common.random.RandomHelper

object TwitterImageJsonFactory {
    fun create(
            miniAvatarUrl: String = RandomHelper.randomString(),
            normalAvatarUrl: String = RandomHelper.randomString(),
            biggerAvatarUrl: String = RandomHelper.randomString(),
            originalAvatarUrl: String = RandomHelper.randomString(),
            imageUrl: String = RandomHelper.randomString()
    ): TwitterImageJson = com.kgmyshin.annict.workDictionary.infra.api.json.TwitterImageJson(miniAvatarUrl, normalAvatarUrl, biggerAvatarUrl, originalAvatarUrl, imageUrl)
}
