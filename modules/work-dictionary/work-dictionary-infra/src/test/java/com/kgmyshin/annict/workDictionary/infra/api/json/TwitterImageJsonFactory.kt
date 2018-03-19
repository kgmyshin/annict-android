package com.kgmyshin.annict.workDictionary.infra.api.json

import com.kgmyshin.common.random.RandomHelper

internal object TwitterImageJsonFactory {
    fun create(
            miniAvatarUrl: String = RandomHelper.randomString(),
            normalAvatarUrl: String = RandomHelper.randomString(),
            biggerAvatarUrl: String = RandomHelper.randomString(),
            originalAvatarUrl: String = RandomHelper.randomString(),
            imageUrl: String = RandomHelper.randomString()
    ): TwitterImageJson = TwitterImageJson(miniAvatarUrl, normalAvatarUrl, biggerAvatarUrl, originalAvatarUrl, imageUrl)
}
