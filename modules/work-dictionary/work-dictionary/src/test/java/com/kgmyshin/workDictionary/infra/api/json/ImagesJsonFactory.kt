package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper
import kotlin.String

internal object ImagesJsonFactory {
  fun create(
      recommendedUrl: String = RandomHelper.randomString(),
      facebookImageJson: com.kgmyshin.workDictionary.infra.api.json.FacebookImageJson = com.kgmyshin.workDictionary.infra.api.json.FacebookImageJsonFactory.create(),
      twitterImageJson: com.kgmyshin.workDictionary.infra.api.json.TwitterImageJson = com.kgmyshin.workDictionary.infra.api.json.TwitterImageJsonFactory.create()
  ): ImagesJson = com.kgmyshin.workDictionary.infra.api.json.ImagesJson(recommendedUrl, facebookImageJson, twitterImageJson)
}
