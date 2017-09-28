package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class GetWorkListRequestJson(
        @SerializedName("fields") val fields: String?,
        @SerializedName("filter_ids") val filterIds: String?,
        @SerializedName("filter_season") val filterSeason: String?,
        @SerializedName("filter_title") val filterTitle: String?, // 部分一致
        @SerializedName("page") val page: Int,
        @SerializedName("per_page") val perPage: Int, // default: 25, max: 50
        @SerializedName("sort_id") val sortId: String, // "arc" or "desc"
        @SerializedName("sort_season") val sortSeason: String, // "arc" or "desc"
        @SerializedName("sort_watchers_count") val sortWatchersCount: String // "arc" or "desc"
)