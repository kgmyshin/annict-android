package com.kgmyshin.record.infra.api.json

import com.google.gson.annotations.SerializedName
import com.kgmyshin.annict.workDictionary.infra.api.json.WorkJson
import java.util.*

data class ReviewJson(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String,
        @SerializedName("rating_animation_sate") val ratingAnimationState: String,
        @SerializedName("rating_music_state") val ratingMusicState: String,
        @SerializedName("rating_story_state") val ratingStoryState: String,
        @SerializedName("rating_character_state") val ratingCharacterState: String,
        @SerializedName("rating_overall_state") val ratingOverallState: String,
        @SerializedName("likes_count") val likesCount: Int,
        @SerializedName("impressions_count") val impressionsCount: Int,
        @SerializedName("modified_at") val modifiedAt: Date?,
        @SerializedName("created_at") val createdAt: Date?,
        @SerializedName("user") val user: UserJson,
        @SerializedName("work") val work: WorkJson
)