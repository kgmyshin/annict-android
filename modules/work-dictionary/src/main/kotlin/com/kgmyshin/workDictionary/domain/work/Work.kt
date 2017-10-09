package com.kgmyshin.workDictionary.domain.work

import com.kgmyshin.common.dddSupport.Entity
import java.util.*

internal class Work(
        id: WorkId,
        title: String,
        titleKana: String,
        season: Season,
        releasedOn: Date,
        officialSiteUrl: String,
        twitterUserName: String?,
        imageUrl: String?,
        episodesCount: Int,
        watchersCount: Int
) : Entity<WorkId>(id)