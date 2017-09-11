package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class ApplicationJson(
        @SerializedName("uid") private val uid: String
)