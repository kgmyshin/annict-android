package com.kgmyshin.record.domain.impl.work.review

import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.impl.episode.record.RecordConverter
import com.kgmyshin.record.domain.impl.episode.record.RecordRepositoryImpl
import com.kgmyshin.record.infra.api.RecordApiClient
import com.kgmyshin.record.infra.api.json.GetRecordListJsonFactory
import com.kgmyshin.record.infra.api.json.RecordJsonFactory
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RecordRepositoryImplTest {

    @Mock
    private lateinit var apiClient: RecordApiClient
    @Mock
    private lateinit var getAccessTokenService: GetAccessTokenService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFindByEpisodeId() {
        // given
        val episodeId = EpisodeId(RandomHelper.randomString())
        val responseJson = GetRecordListJsonFactory.create()
        val accessToken = RandomHelper.randomString()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getRecords(
                filterEpisodeId = episodeId.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = RecordRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findByEpisodeId(episodeId)

        // then
        val expected = RecordConverter.convertToRecord(responseJson.recordList)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testCreate() {
        // given
        val accessToken = RandomHelper.randomString()
        val record = DomainHelper.record()
        val responseJson = RecordJsonFactory.create()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.createRecord(
                episodeId = record.episodeId.value,
                comment = record.comment,
                ratingState = record.ratingState.rawValue,
                shareFacebook = shareFacebook,
                shareTwitter = shareTwitter,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = RecordRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.create(
                record,
                shareTwitter,
                shareFacebook
        )

        // when
        val expected = RecordConverter.convertToRecord(responseJson)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testUpdate() {
        // given
        val accessToken = RandomHelper.randomString()
        val record = DomainHelper.record()
        val responseJson = RecordJsonFactory.create()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.updateRecord(
                id = record.id.value,
                comment = record.comment,
                ratingState = record.ratingState.rawValue,
                shareFacebook = shareFacebook,
                shareTwitter = shareTwitter,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = RecordRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.update(
                record,
                shareTwitter,
                shareFacebook
        )

        // then
        val expected = RecordConverter.convertToRecord(responseJson)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testDelete() {
        // given
        val accessToken = RandomHelper.randomString()
        val record = DomainHelper.record()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.deleteRecored(
                record.id.value,
                accessToken
        )).thenReturn(Completable.complete())

        // when
        val repository = RecordRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val completable = repository.delete(record)

        // then
        completable.test().await().assertComplete()
    }

}