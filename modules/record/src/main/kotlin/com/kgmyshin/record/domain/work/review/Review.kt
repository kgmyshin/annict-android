package com.kgmyshin.record.domain.work.review

import com.kgmyshin.common.dddSupport.Entity
import com.kgmyshin.record.domain.user.User
import com.kgmyshin.record.domain.work.WorkId

internal class Review(
        id: ReviewId,
        val title: String,
        val body: String,
        val ratingAnimationState: RatingState,
        val ratingMusicState: RatingState,
        val ratingStoryState: RatingState,
        val ratingCharacterState: RatingState,
        val ratingOvarallState: RatingState,
        val user: User,
        val workId: WorkId,
        val likesCount: Int = 0,
        val impressionsCount: Int = 0
) : Entity<ReviewId>(id)