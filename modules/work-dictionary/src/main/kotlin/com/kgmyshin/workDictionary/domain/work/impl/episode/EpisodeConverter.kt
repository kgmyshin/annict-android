package com.kgmyshin.workDictionary.domain.work.impl.episode

import com.kgmyshin.workDictionary.domain.work.episode.Episode
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeId
import com.kgmyshin.workDictionary.infra.api.json.EpisodeJson

internal object EpisodeConverter {

    fun convertToEpisode(listJson: List<EpisodeJson>): List<Episode> = listJson.map { convertToEpisode(it) }

    fun convertToEpisode(json: EpisodeJson) =
            Episode(
                    id = EpisodeId(json.id),
                    number = json.sortNumber,
                    title = json.title
            )

}