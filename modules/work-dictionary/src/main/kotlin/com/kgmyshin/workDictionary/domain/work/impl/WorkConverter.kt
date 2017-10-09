package com.kgmyshin.workDictionary.domain.work.impl

import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.infra.api.json.WorkJson

internal object WorkConverter {

    fun convertToDomainModel(listJson: List<WorkJson>): List<Work> =
            listJson.map { convertToDomainModel(it) }

    fun convertToDomainModel(json: WorkJson): Work =
            Work(
                    id = WorkId(json.id),
                    title = json.title,
                    titleKana = json.titleKana,
                    season = Season(json.seasonName),
                    releasedOn = json.releasedOn,
                    officialSiteUrl = json.officialSiteUrl,
                    twitterUserName = json.twitterUserName,
                    imageUrl = json.imagesJson.recommendedUrl,
                    episodesCount = json.episodeCount,
                    watchersCount = json.watchersCount
            )

}