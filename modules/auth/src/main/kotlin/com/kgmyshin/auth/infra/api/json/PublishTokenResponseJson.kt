package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class PublishTokenResponseJson(
        @SerializedName("access_token") val accessToken: String,
        @SerializedName("token_type") val tokenType: String,
        @SerializedName("scope") val scope: String,
        @SerializedName("created_at") val createdAt: Long
)