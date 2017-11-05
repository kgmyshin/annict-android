package com.kgmyshin.workDictionary.domain.impl

import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.impl.work.WorkConverter
import com.kgmyshin.workDictionary.domain.impl.work.WorkRepositoryImpl
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.workDictionary.infra.api.json.GetWorkListResponseJsonFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class WorkRepositoryImplTest {

    @Mock
    private lateinit var apiClient: WorkDictionaryApiClient
    @Mock
    private lateinit var getAccessTokenService: GetAccessTokenService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFind() {
        // given
        val id = WorkId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getWorkList(
                filterIds = id.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = WorkRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val maybe = repository.find(id)

        // then
        val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList[0])
        maybe.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testFindAllByKeyword() {
        // given
        val keyword = RandomHelper.randomString()
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getWorkList(
                filterTitle = keyword,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = WorkRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findAllByKeyword(keyword)


        // then
        val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testFindAllBySeason() {
        // given
        val season = Season(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getWorkList(
                filterSeason = season.name,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = WorkRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findAllBySeason(season)

        // then
        val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testFindAllPopular() {
        // given
        val accessToken = RandomHelper.randomString()
        val responseJson = GetWorkListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getWorkList(
                sortWatchersCount = "asc",
                accessToken = accessToken,
                perPage = 50
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = WorkRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findAllPopular()

        // then
        val expected = WorkConverter.convertToDomainModel(responseJson.workJsonList)
        single.test().await().assertValue(expected).assertComplete()
    }


}