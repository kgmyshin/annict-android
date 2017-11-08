package com.kgmyshin.record.usecase.work.review

import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.Review
import io.reactivex.Single

internal interface GetReviewListUseCase {

    fun execute(workId: WorkId): Single<List<Review>>

}