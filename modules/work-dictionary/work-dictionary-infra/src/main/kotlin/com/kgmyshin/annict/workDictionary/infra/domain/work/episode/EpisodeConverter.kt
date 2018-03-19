package com.kgmyshin.annict.workDictionary.infra.domain.work.episode

import com.kgmyshin.annict.workDictionary.domain.work.episode.Episode
import com.kgmyshin.annict.workDictionary.domain.work.episode.EpisodeId
import com.kgmyshin.annict.workDictionary.infra.api.json.EpisodeJson

internal object EpisodeConverter {

    fun convertToEpisode(listJson: List<EpisodeJson>): List<Episode> = listJson.map { convertToEpisode(it) }

    fun convertToEpisode(json: EpisodeJson) =
            Episode(
                    id = EpisodeId(json.id),
                    number = json.sortNumber,
                    title = json.title
            )

}