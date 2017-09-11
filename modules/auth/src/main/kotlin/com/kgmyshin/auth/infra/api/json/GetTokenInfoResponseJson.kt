package com.kgmyshin.auth.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class GetTokenInfoResponseJson(
        @SerializedName("resource_owner_id") private val resourceOwnerId: Long,
        @SerializedName("scopes") private val scopes: List<String>,
        // TODO: Int?で良い気がするが何が返って来るかdocからはわからないので、一旦String?としてる。要調査.
        @SerializedName("expires_in_seconds") private val expiresInSeconds: String?,
        @SerializedName("application") private val application: ApplicationJson,
        @SerializedName("created_at") private val createdAt: Long
)