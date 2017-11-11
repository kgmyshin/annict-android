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
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(JUnitPlatform::class)
internal class EpisodeRepositoryImplSpec : SubjectSpek<EpisodeRepositoryImpl>({

    val apiClient = Mockito.mock(WorkDictionaryApiClient::class.java)
    val getAccessTokenService = Mockito.mock(GetAccessTokenService::class.java)

    subject {
        EpisodeRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
    }

    given("WorkDictionaryApiClient.getEpisodeList with filterIds return GetWorkListResponseJson") {
        val id = EpisodeId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetEpisodeListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getEpisodeList(
                filterIds = id.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        on("findById") {
            val maybe = subject.findById(id)

            it("should return episode") {
                val expected = EpisodeConverter.convertToEpisode(responseJson.episodeJsonList[0])
                maybe.test().await().assertValue(expected).assertComplete()
            }
        }
    }

    given("WorkDictionaryApiClient.getEpisodeList with filterWorkId return GetWorkListResponseJson") {
        val workId = WorkId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetEpisodeListResponseJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getEpisodeList(
                filterWorkId = workId.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        on("findAllByWorkId") {
            val single = subject.findAllByWorkId(workId)

            on("should return episodeList") {
                val expected = EpisodeConverter.convertToEpisode(responseJson.episodeJsonList)
                single.test().await().assertValue(expected).assertComplete()
            }
        }
    }

})