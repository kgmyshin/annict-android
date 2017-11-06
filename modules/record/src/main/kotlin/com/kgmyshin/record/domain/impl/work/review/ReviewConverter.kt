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
                    ratingAnimationState = RatingState.rawValueOf(json.ratingAnimationState),
                    ratingMusicState = RatingState.rawValueOf(json.ratingMusicState),
                    ratingStoryState = RatingState.rawValueOf(json.ratingStoryState),
                    ratingCharacterState = RatingState.rawValueOf(json.ratingCharacterState),
                    ratingOvarallState = RatingState.rawValueOf(json.ratingOverallState),
                    user = UserConverter.convertToUser(json.user),
                    workId = WorkId(json.work.id),
                    likesCount = json.likesCount,
                    impressionsCount = json.impressionsCount
            )

}