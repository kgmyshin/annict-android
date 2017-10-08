package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName
import com.kgmyshin.common.api.AccessTokenRequestJson

internal data class GetWorkListRequestJson(
        @SerializedName("fields") val fields: String? = null,
        @SerializedName("filter_ids") val filterIds: String? = null,
        @SerializedName("filter_season") val filterSeason: String? = null,
        @SerializedName("filter_title") val filterTitle: String? = null, // 部分一致
        @SerializedName("page") val page: Int = 0,
        @SerializedName("per_page") val perPage: Int = 50, // default: 25, max: 50
        @SerializedName("sort_id") val sortId: String? = null, // "asc" or "desc"
        @SerializedName("sort_season") val sortSeason: String? = null, // "asc" or "desc"
        @SerializedName("sort_watchers_count") val sortWatchersCount: String? = null, // "asc" or "desc"
        @SerializedName("access_token") override val accessToken: String
) : AccessTokenRequestJson