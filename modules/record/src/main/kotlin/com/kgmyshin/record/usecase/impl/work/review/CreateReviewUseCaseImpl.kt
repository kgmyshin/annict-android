package com.kgmyshin.record.usecase.impl.work.review

import com.kgmyshin.record.domain.work.review.Review
import com.kgmyshin.record.domain.work.review.ReviewRepository
import com.kgmyshin.record.usecase.work.review.CreateReviewUseCase
import io.reactivex.Completable

internal class CreateReviewUseCaseImpl(private val repository: ReviewRepository) : CreateReviewUseCase {
    override fun execute(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Completable = repository.create(
            review,
            shareTwitter,
            shareFacebook
    ).toCompletable()
}