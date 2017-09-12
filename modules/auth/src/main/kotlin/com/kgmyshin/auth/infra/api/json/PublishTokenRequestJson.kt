package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName
import com.kgmyshin.auth.BuildConfig

internal data class PublishTokenRequestJson(
        @SerializedName("client_id") private val clientId: String = BuildConfig.ANNICT_CLIENT_ID,
        @SerializedName("client_secret") private val clientSecret: String = BuildConfig.ANNICT_CLIENT_SECRET,
        @SerializedName("grant_type") private val grantType: String = "redirect_uri",
        @SerializedName("redirect_uri") private val redirectUri: String = "urn:ietf:wg:oauth:2.0:oob",
        @SerializedName("code") private val code: String
)