package com.kgmyshin.workDictionary.ui.work

import java.util.*

data class WorkViewModel(
        val id: String,
        val title: String,
        val titleKana: String,
        val season: SeasonViewModel,
        val releasedOn: Date,
        val officialSiteUrl: String,
        val twitterUserName: String?,
        val imageUrl: String?,
        val episodesCount: Int,
        val watchersCount: Int
)