package com.kgmyshin.record.usecase.work.review

import com.kgmyshin.record.domain.work.review.Review
import io.reactivex.Completable

internal interface CreateReviewUseCase {

    fun execute(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Completable

}