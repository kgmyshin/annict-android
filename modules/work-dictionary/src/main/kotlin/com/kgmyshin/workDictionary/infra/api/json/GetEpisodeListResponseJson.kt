package com.kgmyshin.workDictionary.infra.api.json

import com.google.gson.annotations.SerializedName

data class GetEpisodeListResponseJson(
        @SerializedName("episodes") val episodeJsonList: List<EpisodeJson>
)