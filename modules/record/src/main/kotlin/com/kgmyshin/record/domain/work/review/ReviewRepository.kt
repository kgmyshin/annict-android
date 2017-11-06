package com.kgmyshin.record.domain.work.review

import com.kgmyshin.record.domain.work.WorkId
import io.reactivex.Completable
import io.reactivex.Single

internal interface ReviewRepository {

    fun findByWorkId(workId: WorkId): Single<List<Review>>

    fun create(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Review>

    fun update(
            review: Review,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Single<Review>

    fun delete(review: Review): Completable

}