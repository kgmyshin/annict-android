package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper

internal object GetEpisodeListResponseJsonFactory {
  fun create(episodeJsonList: List<com.kgmyshin.workDictionary.infra.api.json.EpisodeJson> = listOf(com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create(), com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create())): GetEpisodeListResponseJson = com.kgmyshin.workDictionary.infra.api.json.GetEpisodeListResponseJson(episodeJsonList)
}
