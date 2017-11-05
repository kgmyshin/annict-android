package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class GetWorkListResponseJson(
        @SerializedName("works") val workJsonList: List<WorkJson>
)