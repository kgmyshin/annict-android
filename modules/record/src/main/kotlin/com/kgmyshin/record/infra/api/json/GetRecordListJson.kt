package com.kgmyshin.record.infra.api.json

import com.google.gson.annotations.SerializedName

data class GetRecordListJson(
        @SerializedName("records") val recordList: List<RecordJson>
)