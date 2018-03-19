package com.kgmyshin.annict.workDictionary.infra.domain.work

import com.kgmyshin.annict.workDictionary.domain.work.Season
import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.infra.api.json.WorkJson


internal object WorkConverter {

    fun convertToDomainModel(listJson: List<WorkJson>): List<Work> =
            listJson.map { convertToDomainModel(it) }

    fun convertToDomainModel(json: WorkJson): Work =
            Work(
                    id = WorkId(json.id),
                    title = json.title,
                    titleKana = json.titleKana,
                    season = json.seasonName?.let { Season(it) },
                    officialSiteUrl = json.officialSiteUrl,
                    twitterUserName = json.twitterUserName,
                    imageUrl = json.imagesJson.recommendedUrl,
                    episodesCount = json.episodeCount,
                    watchersCount = json.watchersCount
            )

}