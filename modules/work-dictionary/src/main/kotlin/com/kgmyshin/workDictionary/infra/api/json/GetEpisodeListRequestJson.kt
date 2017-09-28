package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class GetEpisodeListRequestJson(
        @SerializedName("fields") val fields: String,
        @SerializedName("filter_ids") val filterIds: String,
        @SerializedName("filter_work_id") val filterWorkId: String,
        @SerializedName("page") val page: Int,
        @SerializedName("per_page") val perPage: Int, // default 25, max 50
        @SerializedName("sort_id") val sortId: String, // "asc or "desc
        @SerializedName("sort_sort_number") val sortSortNumber: String // "asc or "desc
)