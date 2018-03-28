package com.kgmyshin.annict.workDictionary.ui.work

data class WorkBindingModel(
        val id: String,
        val title: String,
        val titleKana: String,
        val season: SeasonBindingModel?,
        val officialSiteUrl: String,
        val twitterUserName: String?,
        val imageUrl: String?,
        val episodesCount: Int,
        val watchersCount: Int
)