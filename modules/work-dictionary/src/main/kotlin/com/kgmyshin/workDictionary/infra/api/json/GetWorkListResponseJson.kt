package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

internal data class GetWorkListResponseJson(
        @SerializedName("works") val workJsonList: List<WorkJson>
)