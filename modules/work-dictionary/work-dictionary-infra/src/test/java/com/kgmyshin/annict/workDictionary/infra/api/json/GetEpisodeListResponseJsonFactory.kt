package com.kgmyshin.annict.workDictionary.infra.api.json

internal object GetEpisodeListResponseJsonFactory {
    fun create(episodeJsonList: List<EpisodeJson> = listOf(EpisodeJsonFactory.create(), EpisodeJsonFactory.create(), EpisodeJsonFactory.create())): GetEpisodeListResponseJson = GetEpisodeListResponseJson(episodeJsonList)
}
