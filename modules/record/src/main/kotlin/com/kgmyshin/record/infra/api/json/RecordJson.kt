package com.kgmyshin.record.infra.api.json

import com.google.gson.annotations.SerializedName
import com.kgmyshin.annict.workDictionary.infra.api.json.EpisodeJson
import com.kgmyshin.annict.workDictionary.infra.api.json.WorkJson
import java.util.*

data class RecordJson(
        @SerializedName("id") val id: String,
        @SerializedName("comment") val comment: String,
        @SerializedName("rating") val rating: Int,
        @SerializedName("rating_state") val ratingState: String,
        @SerializedName("is_modified") val isModified: Boolean,
        @SerializedName("likes_count") val likesCount: Int,
        @SerializedName("comments_count") val commentsCount: Int,
        @SerializedName("created_at") val createdAt: Date,
        @SerializedName("user") val user: UserJson,
        @SerializedName("work") val work: WorkJson,
        @SerializedName("episode") val episode: EpisodeJson
)