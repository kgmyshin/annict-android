package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper

internal object GetWorkListResponseJsonFactory {
  fun create(workJsonList: List<com.kgmyshin.workDictionary.infra.api.json.WorkJson> = listOf(com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create())): GetWorkListResponseJson = com.kgmyshin.workDictionary.infra.api.json.GetWorkListResponseJson(workJsonList)
}
