package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class ImagesJson(
        @SerializedName("recommended_url") val recommendedUrl: String,
        @SerializedName("facebook") val facebookImageJson: FacebookImageJson,
        @SerializedName("twitter") val twitterImageJson: TwitterImageJson
)