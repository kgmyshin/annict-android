package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.FacebookImageJson
import com.kgmyshin.random.RandomHelper
import kotlin.String

object FacebookImageJsonFactory {
  fun create(ogImageUrl: String = RandomHelper.randomString()): FacebookImageJson = com.kgmyshin.annict.workDictionary.infra.api.json.FacebookImageJson(ogImageUrl)
}
