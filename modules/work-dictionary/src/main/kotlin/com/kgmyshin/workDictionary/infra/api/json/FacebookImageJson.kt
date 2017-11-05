package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class FacebookImageJson(
        @SerializedName("og_image_url") val ogImageUrl: String
)