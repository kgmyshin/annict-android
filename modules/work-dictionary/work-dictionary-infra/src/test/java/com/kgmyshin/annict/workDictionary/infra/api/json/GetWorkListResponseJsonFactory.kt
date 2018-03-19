package com.kgmyshin.annict.workDictionary.infra.api.json

internal object GetWorkListResponseJsonFactory {
    fun create(workJsonList: List<WorkJson> = listOf(com.kgmyshin.annict.workDictionary.infra.api.json.WorkJsonFactory.create(), WorkJsonFactory.create(), com.kgmyshin.annict.workDictionary.infra.api.json.WorkJsonFactory.create())): GetWorkListResponseJson = com.kgmyshin.annict.workDictionary.infra.api.json.GetWorkListResponseJson(workJsonList)
}
