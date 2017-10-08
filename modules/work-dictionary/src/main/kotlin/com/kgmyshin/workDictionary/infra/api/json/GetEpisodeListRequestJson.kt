package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName
import com.kgmyshin.common.api.AccessTokenRequestJson

internal data class GetEpisodeListRequestJson(
        @SerializedName("fields") val fields: String? = null,
        @SerializedName("filter_ids") val filterIds: String? = null,
        @SerializedName("filter_work_id") val filterWorkId: String? = null,
        @SerializedName("page") val page: Int = 0,
        @SerializedName("per_page") val perPage: Int = 50, // default 25, max 50
        @SerializedName("sort_id") val sortId: String? = null, // "asc or "desc
        @SerializedName("sort_sort_number") val sortSortNumber: String? = null, // "asc or "desc
        @SerializedName("access_token") override val accessToken: String
) : AccessTokenRequestJson