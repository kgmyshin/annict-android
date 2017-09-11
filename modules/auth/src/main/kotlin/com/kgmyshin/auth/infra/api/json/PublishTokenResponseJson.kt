package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class PublishTokenResponseJson(
        @SerializedName("access_token") private val accessToken: String,
        @SerializedName("token_type") private val tokenType: String,
        @SerializedName("scope") private val scope: String,
        @SerializedName("created_at") private val createdAt: Long
)