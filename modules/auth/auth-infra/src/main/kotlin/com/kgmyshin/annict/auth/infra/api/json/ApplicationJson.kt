package com.kgmyshin.annict.auth.infra.api.json

import com.google.gson.annotations.SerializedName

data class ApplicationJson(
        @SerializedName("uid") private val uid: String
)