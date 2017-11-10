package com.kgmyshin.record.usecase.impl.work.review

import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.Review
import com.kgmyshin.record.domain.work.review.ReviewRepository
import com.kgmyshin.record.usecase.work.review.GetReviewListUseCase
import io.reactivex.Single

internal class GetReviewListUseCaseImpl(private val repository: ReviewRepository) : GetReviewListUseCase {

    override fun execute(workId: WorkId): Single<List<Review>> = repository.findByWorkId(workId)

}