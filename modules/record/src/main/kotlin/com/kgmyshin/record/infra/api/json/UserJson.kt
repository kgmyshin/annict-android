package com.kgmyshin.record.infra.api.json

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserJson(
        @SerializedName("id") val id: String,
        @SerializedName("username") val username: String,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("background_image_url") val backgroundImageUrl: String,
        @SerializedName("records_count") val recordsCount: Int,
        @SerializedName("created_at") val createdAt: Date
)