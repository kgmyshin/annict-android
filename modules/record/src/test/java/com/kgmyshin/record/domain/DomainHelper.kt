package com.kgmyshin.record.domain

import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.Record
import com.kgmyshin.record.domain.episode.record.RecordId
import com.kgmyshin.record.domain.user.User
import com.kgmyshin.record.domain.user.UserId
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.Review
import com.kgmyshin.record.domain.work.review.ReviewId
import com.kgmyshin.record.domain.episode.record.RatingState as EpisodeRatingState
import com.kgmyshin.record.domain.work.review.RatingState as ReviewRunningState

internal object DomainHelper {

    fun record(): Record = Record(
            RecordId(RandomHelper.randomString()),
            RandomHelper.randomString(),
            EpisodeRatingState.Average,
            RandomHelper.randomBoolean(),
            RandomHelper.randomInt(),
            RandomHelper.randomInt(),
            user(),
            WorkId(RandomHelper.randomString()),
            EpisodeId(RandomHelper.randomString())
    )

    fun user(): User = User(
            UserId(RandomHelper.randomString()),
            RandomHelper.randomString()
    )

    fun review(): Review = Review(
            ReviewId(RandomHelper.randomString()),
            RandomHelper.randomString(),
            RandomHelper.randomString(),
            ReviewRunningState.Average,
            ReviewRunningState.Average,
            ReviewRunningState.Average,
            ReviewRunningState.Average,
            ReviewRunningState.Average,
            user(),
            WorkId(RandomHelper.randomString()),
            RandomHelper.randomInt(),
            RandomHelper.randomInt()
    )

}