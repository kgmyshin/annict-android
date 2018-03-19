package com.kgmyshin.record.domain.impl.episode.record

import com.kgmyshin.annict.auth.hostService.GetAccessTokenService
import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.impl.work.review.ReviewConverter
import com.kgmyshin.record.domain.impl.work.review.ReviewRepositoryImpl
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.infra.api.RecordApiClient
import com.kgmyshin.record.infra.api.json.GetReviewListJsonFactory
import com.kgmyshin.record.infra.api.json.ReviewJsonFactory
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ReviewRepositoryImplTest {

    @Mock
    private lateinit var apiClient: RecordApiClient
    @Mock
    private lateinit var getAccessTokenService: GetAccessTokenService

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFindByWorkId() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val accessToken = RandomHelper.randomString()
        val responseJson = GetReviewListJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.getReviews(
                filterWorkId = workId.value,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = ReviewRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.findByWorkId(workId)

        // then
        val expected = ReviewConverter.convertToReview(responseJson.reviewList)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testCreate() {
        // given
        val accessToken = RandomHelper.randomString()
        val review = DomainHelper.review()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        val responseJson = ReviewJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.createReview(
                workId = review.workId.value,
                title = review.title,
                body = review.body,
                ratingAnimationState = review.ratingAnimationState.rawValue,
                ratingMusicState = review.ratingMusicState.rawValue,
                ratingStoryState = review.ratingStoryState.rawValue,
                ratingCharacterState = review.ratingCharacterState.rawValue,
                ratingOverallState = review.ratingCharacterState.rawValue,
                shareTwitter = shareTwitter,
                shareFacebook = shareFacebook,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = ReviewRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.create(
                review,
                shareTwitter,
                shareFacebook
        )

        // then
        val expected = ReviewConverter.convertToReview(responseJson)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testUpdate() {
        // given
        val accessToken = RandomHelper.randomString()
        val review = DomainHelper.review()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        val responseJson = ReviewJsonFactory.create()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.updateReview(
                id = review.id.value,
                title = review.title,
                body = review.body,
                ratingAnimationState = review.ratingAnimationState.rawValue,
                ratingMusicState = review.ratingMusicState.rawValue,
                ratingStoryState = review.ratingStoryState.rawValue,
                ratingCharacterState = review.ratingCharacterState.rawValue,
                ratingOverallState = review.ratingCharacterState.rawValue,
                shareTwitter = shareTwitter,
                shareFacebook = shareFacebook,
                accessToken = accessToken
        )).thenReturn(Single.just(responseJson))

        // when
        val repository = ReviewRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val single = repository.update(
                review,
                shareTwitter,
                shareFacebook
        )

        // then
        val expected = ReviewConverter.convertToReview(responseJson)
        single.test().await().assertValue(expected).assertComplete()
    }

    @Test
    fun testDelete() {
        // given
        val accessToken = RandomHelper.randomString()
        val review = DomainHelper.review()
        Mockito.`when`(getAccessTokenService.execute()).thenReturn(Single.just(accessToken))
        Mockito.`when`(apiClient.deleteReview(
                review.id.value,
                accessToken
        )).thenReturn(Completable.complete())

        // when
        val repository = ReviewRepositoryImpl(
                apiClient,
                getAccessTokenService,
                Schedulers.trampoline()
        )
        val completable = repository.delete(review)

        // then
        completable.test().await().assertComplete()
    }

}