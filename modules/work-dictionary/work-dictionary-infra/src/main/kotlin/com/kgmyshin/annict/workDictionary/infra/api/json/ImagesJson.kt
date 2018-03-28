package com.kgmyshin.annict.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class ImagesJson(
        @SerializedName("recommended_url") val recommendedUrl: String?,
        @SerializedName("facebook") val facebookImageJson: FacebookImageJson,
        @SerializedName("twitter") val twitterImageJson: TwitterImageJson
)