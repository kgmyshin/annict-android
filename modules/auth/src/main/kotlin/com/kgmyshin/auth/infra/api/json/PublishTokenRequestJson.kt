package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class PublishTokenRequestJson(
        @SerializedName("client_id") private val clientId: String,
        @SerializedName("client_secret") private val clientSecret: String,
        @SerializedName("grant_type") private val grantType: String = "redirect_uri",
        @SerializedName("redirect_uri") private val redirectUri: String = "urn:ietf:wg:oauth:2.0:oob",
        @SerializedName("code") private val code: String
)