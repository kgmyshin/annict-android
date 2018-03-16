package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.GetEpisodeListResponseJson
import com.kgmyshin.random.RandomHelper

object GetEpisodeListResponseJsonFactory {
  fun create(episodeJsonList: List<com.kgmyshin.annict.workDictionary.infra.api.json.EpisodeJson> = listOf(com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create())): GetEpisodeListResponseJson = com.kgmyshin.annict.workDictionary.infra.api.json.GetEpisodeListResponseJson(episodeJsonList)
}
