package com.kgmyshin.record.infra.api.json

import com.google.gson.annotations.SerializedName

data class GetReviewListJson(
        @SerializedName("reviews") val reviewList: List<ReviewJson>
)