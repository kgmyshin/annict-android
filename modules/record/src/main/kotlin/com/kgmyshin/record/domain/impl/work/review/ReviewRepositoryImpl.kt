package com.kgmyshin.record.domain.impl.work.review

import android.support.v4.util.LruCache
import com.kgmyshin.auth.hostService.GetAccessTokenService
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.Review
import com.kgmyshin.record.domain.work.review.ReviewRepository
import com.kgmyshin.record.infra.api.RecordApiClient
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Named

internal class ReviewRepositoryImpl(
        private val apiClient: RecordApiClient,
        private val getAccessTokenService: GetAccessTokenService,
        @Named("io") private val ioScheduler: Scheduler
) : ReviewRepository {

    private val workIdCache: LruCache<WorkId, List<Review>> = LruCache(1000)

    override fun findByWorkId(workId: WorkId): Single<List<Review>> =
            if (workIdCache.get(workId) != null) {
                Single.just(workIdCache.get(workId))
            } else {
                getAccessTokenService.execute().flatMap { accessToken ->
                    apiClient.getReviews(
                            filterWorkId = workId.value,
                            accessToken = accessToken
                    )
                }.map {
                    ReviewConverter.convertToReview(it.reviewList)
                }.doOnSuccess { reviewList ->
                    workIdCache.put(
                            workId,
                            reviewList
                    )
                }.subscribeOn(ioScheduler)
            }

    override fun create(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Review> =
            getAccessTokenService.execute().flatMap { accessToken ->
                apiClient.createReview(
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
                )
            }.map {
                ReviewConverter.convertToReview(it)
            }.doOnSuccess { createdReview ->
                workIdCache.get(createdReview.workId)?.let {
                    workIdCache.put(
                            createdReview.workId,
                            listOf(createdReview).plus(it)
                    )
                }
            }.subscribeOn(ioScheduler)

    override fun update(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Review> =
            getAccessTokenService.execute().flatMap { accessToken ->
                apiClient.updateReview(
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
                )
            }.map {
                ReviewConverter.convertToReview(it)
            }.doOnSuccess {
                workIdCache.get(review.workId)?.let {
                    workIdCache.put(
                            review.workId,
                            it.toMutableList().apply {
                                set(
                                        it.indexOfFirst { it.id == review.id },
                                        review
                                )
                            }.toList()
                    )
                }
            }.subscribeOn(ioScheduler)

    override fun delete(review: Review): Completable =
            getAccessTokenService.execute().flatMapCompletable { accessToken ->
                apiClient.deleteReview(
                        id = review.id.value,
                        accessToken = accessToken
                )
            }.doOnComplete {
                workIdCache.get(review.workId)?.let {
                    workIdCache.put(
                            review.workId,
                            it.minus(review)
                    )
                }
            }.subscribeOn(ioScheduler)

}