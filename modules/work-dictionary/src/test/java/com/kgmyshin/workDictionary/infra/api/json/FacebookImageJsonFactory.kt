package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper
import kotlin.String

internal object FacebookImageJsonFactory {
  fun create(ogImageUrl: String = RandomHelper.randomString()): FacebookImageJson = com.kgmyshin.workDictionary.infra.api.json.FacebookImageJson(ogImageUrl)
}
