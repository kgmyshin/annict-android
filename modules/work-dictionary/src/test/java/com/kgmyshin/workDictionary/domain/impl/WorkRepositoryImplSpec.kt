package com.kgmyshin.workDictionary.domain.impl

import com.kgmyshin.annict.auth.hostService.GetAccessTokenService
import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.impl.work.WorkConverter
import com.kgmyshin.workDictionary.domain.impl.work.WorkRepositoryImpl
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.workDictionary.infra.api.json.GetWorkListResponseJsonFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class WorkRepositoryImplSpec : SubjectSpek<WorkRepositoryImpl>({

    val apiClient = Mockito.mock(WorkDictionaryApiClient::class.java)
    val getAccessTokenService = Mockito.mock(GetAccessTokenService::class.java)

    subject {
        WorkRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
    }

    given("WorkDictionaryApiClient.getWorkList with fitlerId return GetWorkListResponseJson") {

        val id = WorkId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()

        beforeGroup {
            Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
            Mockito.`when`(apiClient.getWorkList(
                    filterIds = id.value,
                    accessToken = accessToken
            )).thenReturn(Single.just(responseJson))
        }

        on("findById") {
            val maybe = subject.findById(id)

            it("should return work") {
                val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList[0])
                maybe.test().await().assertValue(expected).assertComplete()
            }
        }
    }

    given("WorkDictionaryApiClient.getWorkList with fitlerTitle return GetWorkListResponseJson") {
        val keyword = RandomHelper.randomString()
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()

        beforeGroup {
            Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
            Mockito.`when`(apiClient.getWorkList(
                    filterTitle = keyword,
                    accessToken = accessToken
            )).thenReturn(Single.just(responseJson))
        }


        on("findAllByKeyword") {
            val single = subject.findAllByKeyword(keyword)

            it("should return workList") {
                val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
                single.test().await().assertValue(expected).assertComplete()
            }
        }
    }

    given("WorkDictionaryApiClient.getWorkList with filterSeason return GetWorkListResponseJson") {
        val season = Season(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()

        beforeGroup {
            Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
            Mockito.`when`(apiClient.getWorkList(
                    filterSeason = season.name,
                    accessToken = accessToken
            )).thenReturn(Single.just(responseJson))
        }

        on("findAllBySeason") {
            val single = subject.findAllBySeason(season)

            it("should return workList") {
                val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
                single.test().await().assertValue(expected).assertComplete()
            }
        }
    }

    given("WorkDictionaryApiClient.getWorkList with sortWatchersCount=asc return GetWorkListResponseJson") {
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()

        beforeGroup {
            Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
            Mockito.`when`(apiClient.getWorkList(
                    sortWatchersCount = "asc",
                    accessToken = accessToken,
                    perPage = 50
            )).thenReturn(Single.just(responseJson))
        }

        on("findAllPopular") {
            val single = subject.findAllPopular()

            it("should return workList") {
                val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
                single.test().await().assertValue(expected).assertComplete()
            }

        }
    }

})