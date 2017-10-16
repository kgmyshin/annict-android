package com.kgmyshin.workDictionary.domain.impl.work

import android.support.v4.util.LruCache
import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

internal class WorkRepositoryImpl @Inject constructor(
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
                            filterIds = id.value,
                            accessToken = accessToken
                    )
                }.map {
                    WorkConverter.convertToDomainModel(it.workJsonList[0])
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
                            filterTitle = keyword,
                            accessToken = accessToken
                    )
                }.map {
                    WorkConverter.convertToDomainModel(it.workJsonList)
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
                            filterSeason = season.name,
                            accessToken = accessToken
                    )
                }.map {
                    WorkConverter.convertToDomainModel(it.workJsonList)
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
                            sortWatchersCount = "asc",
                            accessToken = accessToken,
                            perPage = 50
                    )
                }.map {
                    WorkConverter.convertToDomainModel(it.workJsonList)
                }.doOnSuccess { workList ->
                    workList.forEach {
                        idCache.put(
                                it.id,
                                it
                        )
                    }
                }.subscribeOn(ioScheduler)
            }

}

