package com.kgmyshin.workDictionary.domain.impl.episode

import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.impl.work.episode.EpisodeConverter
import com.kgmyshin.workDictionary.domain.impl.work.episode.EpisodeRepositoryImpl
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeId
import com.kgmyshin.workDictionary.infra.api.WorkDictionaryApiClient
import com.kgmyshin.workDictionary.infra.api.json.GetEpisodeListResponseJsonFactory
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class EpisodeRepositoryImplTest {

    @Mock
    private lateinit var apiClient: WorkDictionaryApiClient
    @Mock
    private lateinit var getAccessTokenService: GetAccessTokenService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFindById() {
        // given
        val id = EpisodeId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetEpisodeListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getEpisodeList(
                fields = id.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = EpisodeRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val maybe = repository.findById(id)

        // then
        val expected = EpisodeConverter.convertToEpisode(responseJson.episodeJsonList[0])
        maybe.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testFindAllByWorkId() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetEpisodeListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getEpisodeList(
                filterWorkId = workId.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = EpisodeRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findAllByWorkId(workId)

        // then
        val expected = EpisodeConverter.convertToEpisode(responseJson.episodeJsonList)
        single.test().await().assertValue(expected).assertComplete()
    }

}