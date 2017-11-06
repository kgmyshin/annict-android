package com.kgmyshin.record.infra.api.json

import com.kgmyshin.random.RandomHelper
import java.util.*

object ReviewJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            title: String = RandomHelper.randomString(),
            body: String = RandomHelper.randomString(),
            ratingAnimationState: String = "good",
            ratingMusicState: String = "good",
            ratingStoryState: String = "good",
            ratingCharacterState: String = "good",
            ratingOverallState: String = "good",
            likesCount: Int = RandomHelper.randomInt(),
            impressionsCount: Int = RandomHelper.randomInt(),
            modifiedAt: Date = RandomHelper.randomDate(),
            createdAt: Date = RandomHelper.randomDate(),
            user: com.kgmyshin.record.infra.api.json.UserJson = com.kgmyshin.record.infra.api.json.UserJsonFactory.create(),
            work: com.kgmyshin.workDictionary.infra.api.json.WorkJson = com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create()
    ): ReviewJson = com.kgmyshin.record.infra.api.json.ReviewJson(id,
                                                                  title,
                                                                  body,
                                                                  ratingAnimationState,
                                                                  ratingMusicState,
                                                                  ratingStoryState,
                                                                  ratingCharacterState,
                                                                  ratingOverallState,
                                                                  likesCount,
                                                                  impressionsCount,
                                                                  modifiedAt,
                                                                  createdAt,
                                                                  user,
                                                                  work)
}
