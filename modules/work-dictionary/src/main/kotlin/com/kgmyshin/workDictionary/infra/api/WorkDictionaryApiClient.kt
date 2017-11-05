package com.kgmyshin.workDictionary.infra.api

import com.kgmyshin.workDictionary.infra.api.json.GetEpisodeListResponseJson
import com.kgmyshin.workDictionary.infra.api.json.GetWorkListResponseJson
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WorkDictionaryApiClient {

    @GET("/v1/works")
    fun getWorkList(
            @Query("fields") fields: String? = null,
            @Query("filter_ids") filterIds: String? = null,
            @Query("filter_season") filterSeason: String? = null,
            @Query("filter_title") filterTitle: String? = null, // 部分一致
            @Query("page") page: Int = 1,
            @Query("per_page") perPage: Int = 50, // default: 25, max: 50
            @Query("sort_id") sortId: String? = null, // "asc" or "desc"
            @Query("sort_season") sortSeason: String? = null, // "asc" or "desc"
            @Query("sort_watchers_count") sortWatchersCount: String? = null, // "asc" or "desc"
            @Query("access_token") accessToken: String
    ): Single<GetWorkListResponseJson>

    @GET("/v1/episodes")
    fun getEpisodeList(
            @Query("fields") fields: String? = null,
            @Query("filter_ids") filterIds: String? = null,
            @Query("filter_work_id") filterWorkId: String? = null,
            @Query("page") page: Int = 1,
            @Query("per_page") perPage: Int = 50, // default 25, max 50
            @Query("sort_id") sortId: String? = null, // "asc or "desc
            @Query("sort_sort_number") sortSortNumber: String? = null, // "asc or "desc
            @Query("access_token") accessToken: String
    ): Single<GetEpisodeListResponseJson>

}