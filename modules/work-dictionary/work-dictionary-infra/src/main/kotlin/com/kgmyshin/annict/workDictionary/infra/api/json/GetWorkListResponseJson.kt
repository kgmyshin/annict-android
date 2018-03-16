package com.kgmyshin.annict.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class GetWorkListResponseJson(
        @SerializedName("works") val workJsonList: List<WorkJson>
)