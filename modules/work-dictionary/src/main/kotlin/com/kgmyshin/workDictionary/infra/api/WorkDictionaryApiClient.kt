package com.kgmyshin.workDictionary.infra.api

import com.kgmyshin.workDictionary.infra.api.json.GetEpisodeListRequestJson
import com.kgmyshin.workDictionary.infra.api.json.GetWorkListRequestJson
import com.kgmyshin.workDictionary.infra.api.json.GetWorkListResponseJson
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET

internal interface WorkDictionaryApiClient {

    @GET("/v1/works")
    fun getWorkList(@Body req: GetWorkListRequestJson): Single<GetWorkListResponseJson>

    @GET("/v1/episodes")
    fun getEpisodeList(@Body req: GetEpisodeListRequestJson): Single<GetWorkListResponseJson>

}