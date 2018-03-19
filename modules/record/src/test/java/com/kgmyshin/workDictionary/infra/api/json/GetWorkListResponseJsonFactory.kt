package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.GetWorkListResponseJson

object GetWorkListResponseJsonFactory {
  fun create(workJsonList: List<com.kgmyshin.annict.workDictionary.infra.api.json.WorkJson> = listOf(com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create())): GetWorkListResponseJson = com.kgmyshin.annict.workDictionary.infra.api.json.GetWorkListResponseJson(workJsonList)
}
