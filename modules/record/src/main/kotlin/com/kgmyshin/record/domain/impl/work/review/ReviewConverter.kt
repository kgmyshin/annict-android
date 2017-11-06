package com.kgmyshin.record.domain.impl.work.review

import com.kgmyshin.record.domain.impl.user.UserConverter
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.RatingState
import com.kgmyshin.record.domain.work.review.Review
import com.kgmyshin.record.domain.work.review.ReviewId
import com.kgmyshin.record.infra.api.json.ReviewJson

internal object ReviewConverter {

    fun convertToReview(listJson: List<ReviewJson>): List<Review> = listJson.map { convertToReview(it) }

    fun convertToReview(json: ReviewJson): Review =
            Review(
                    id = ReviewId(json.id),
                    title = json.title,
                    body = json.body,
                    ratingAnimationState = RatingState.valueOf(json.ratingAnimationState),
                    ratingMusicState = RatingState.valueOf(json.ratingMusicState),
                    ratingStoryState = RatingState.valueOf(json.ratingStoryState),
                    ratingCharacterState = RatingState.valueOf(json.ratingCharacterState),
                    ratingOvarallState = RatingState.valueOf(json.ratingOverallState),
                    user = UserConverter.convertToUser(json.user),
                    workId = WorkId(json.work.id),
                    likesCount = json.likesCount,
                    impressionsCount = json.impressionsCount
            )

}