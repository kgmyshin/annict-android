package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class TwitterImageJson(
        @SerializedName("mini_avatar_url") val miniAvatarUrl: String,
        @SerializedName("normal_avatar_url") val normalAvatarUrl: String,
        @SerializedName("bigger_avatar_url") val biggerAvatarUrl: String,
        @SerializedName("original_avatar_url") val originalAvatarUrl: String,
        @SerializedName("image_url") val imageUrl: String
)