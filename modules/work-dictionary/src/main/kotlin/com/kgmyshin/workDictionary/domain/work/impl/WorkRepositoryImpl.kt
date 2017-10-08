package com.kgmyshin.workDictionary.domain.work.impl

import android.support.v4.util.LruCache
import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.workDictionary.infra.api.json.*
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Named


internal class WorkRepositoryImpl(
        private val apiClient: WorkDictionaryApiClient,
        private val getAccessTokenService: GetAccessTokenService,
        @Named("io") private val ioScheduler: Scheduler
) : WorkRepository {

    private val idCache: LruCache<WorkId, Work> = LruCache(1000)
    private val keywordCache: LruCache<String, List<Work>> = LruCache(50)
    private val seasonCache: LruCache<Season, List<Work>> = LruCache(10)
    private val popularCache: LruCache<String, List<Work>> = LruCache(1)

    companion object {
        private val SYMBOL_POPULAR = "popular"
    }

    override fun find(id: WorkId): Maybe<Work> =
            if (idCache.get(id) != null) {
                Maybe.just(idCache.get(id))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getWorkList(
                            GetWorkListRequestJson(
                                    filterIds = id.value,
                                    accessToken = accessToken
                            )
                    ).flatMap { getWorkListResponseJson ->
                        apiClient.getEpisodeList(GetEpisodeListRequestJson(
                                filterWorkId = getWorkListResponseJson.workJsonList[0].id,
                                accessToken = accessToken
                        )).map { getEpisodeListResponseJson ->
                            Pair(
                                    getWorkListResponseJson.workJsonList[0],
                                    getEpisodeListResponseJson.episodeJsonList
                            )
                        }
                    }
                }.map {
                    WorkConverter.convertToDomainModel(it)
                }.doOnSuccess { work ->
                    idCache.put(
                            work.id,
                            work
                    )
                }.toMaybe().subscribeOn(ioScheduler)
            }

    override fun findAllByKeyword(keyword: String): Single<List<Work>> =
            if (keywordCache.get(keyword) != null) {
                Single.just(keywordCache.get(keyword))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getWorkList(
                            GetWorkListRequestJson(
                                    filterTitle = keyword,
                                    accessToken = accessToken
                            )
                    ).flatMap { getWorkListResponseJson ->
                        getEpisodeListJsonList(
                                getWorkListResponseJson,
                                accessToken
                        )
                    }
                }.map { pairList ->
                    pairList.map { WorkConverter.convertToDomainModel(it) }
                }.doOnSuccess { workList ->
                    keywordCache.put(
                            keyword,
                            workList
                    )
                    workList.forEach {
                        idCache.put(
                                it.id,
                                it
                        )
                    }
                }.subscribeOn(ioScheduler)
            }

    override fun findAllBySeason(season: Season): Single<List<Work>> =
            if (seasonCache.get(season) != null) {
                Single.just(seasonCache.get(season))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getWorkList(
                            GetWorkListRequestJson(
                                    filterSeason = season.name,
                                    accessToken = accessToken
                            )
                    ).flatMap { getWorkListResponseJson ->
                        getEpisodeListJsonList(
                                getWorkListResponseJson,
                                accessToken
                        )
                    }
                }.map { pairList ->
                    pairList.map { WorkConverter.convertToDomainModel(it) }
                }.doOnSuccess { workList ->
                    seasonCache.put(
                            season,
                            workList
                    )
                    workList.forEach {
                        idCache.put(
                                it.id,
                                it
                        )
                    }
                }.subscribeOn(ioScheduler)
            }

    override fun findAllPopular(): Single<List<Work>> =
            if (popularCache.get(SYMBOL_POPULAR) != null) {
                Single.just(popularCache.get(SYMBOL_POPULAR))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getWorkList(
                            GetWorkListRequestJson(
                                    sortWatchersCount = "asc",
                                    accessToken = accessToken
                            )
                    ).flatMap { getWorkListResponseJson ->
                        getEpisodeListJsonList(
                                getWorkListResponseJson,
                                accessToken
                        )
                    }
                }.map { pairList ->
                    pairList.map { WorkConverter.convertToDomainModel(it) }
                }.doOnSuccess { workList ->
                    popularCache.put(
                            SYMBOL_POPULAR,
                            workList
                    )
                    workList.forEach {
                        idCache.put(
                                it.id,
                                it
                        )
                    }
                }.subscribeOn(ioScheduler)
            }

    private fun getEpisodeListJsonList(
            getWorkListResponseJson: GetWorkListResponseJson,
            accessToken: String
    ): Single<List<Pair<WorkJson, List<EpisodeJson>>>> =
            getWorkListResponseJson.workJsonList.map { workJson ->
                apiClient.getEpisodeList(
                        GetEpisodeListRequestJson(
                                filterWorkId = workJson.id,
                                accessToken = accessToken
                        )
                ).map { getEpisodeListResponseJson ->
                    Pair(
                            workJson,
                            getEpisodeListResponseJson.episodeJsonList
                    )
                }
            }.let { Single.concat(it) }.toList()

}

