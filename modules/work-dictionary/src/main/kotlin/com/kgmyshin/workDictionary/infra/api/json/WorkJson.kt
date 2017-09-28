package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName
import java.util.*


internal data class WorkJson(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("title_kana") val titleKana: String,
        @SerializedName("media") val media: String,
        @SerializedName("media_text") val mediaText: String,
        @SerializedName("season_name") val seasonName: String,
        @SerializedName("season_name_text") val seasonNameText: String,
        @SerializedName("released_on") val releasedOn: Date,
        @SerializedName("released_on_about") val releasedOnAbout: Date,
        @SerializedName("official_site_url") val officialSiteUrl: String,
        @SerializedName("wikipedia_url") val wikipediaUrl: String,
        @SerializedName("twitter_username") val twitterUserName: String,
        @SerializedName("twitter_hashtag") val twitterHashTag: String,
        @SerializedName("images") val imagesJson: ImagesJson,
        @SerializedName("episodes_count") val episodeCount: Int,
        @SerializedName("watchers_count") val watchersCount: Int,
        @SerializedName("reviews_count") val reviewsCount: Int,
        @SerializedName("no_episodes") val noEpisodes: Boolean
)