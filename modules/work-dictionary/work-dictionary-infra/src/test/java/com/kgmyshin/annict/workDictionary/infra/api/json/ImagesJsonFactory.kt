package com.kgmyshin.annict.workDictionary.infra.api.json


import com.kgmyshin.common.random.RandomHelper

internal object ImagesJsonFactory {
    fun create(
            recommendedUrl: String = RandomHelper.randomString(),
            facebookImageJson: FacebookImageJson = FacebookImageJsonFactory.create(),
            twitterImageJson: TwitterImageJson = TwitterImageJsonFactory.create()
    ): ImagesJson = ImagesJson(recommendedUrl, facebookImageJson, twitterImageJson)
}
