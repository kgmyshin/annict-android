package com.kgmyshin.record.infra.api.json

import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory
import com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory
import java.util.*

object RecordJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            comment: String = RandomHelper.randomString(),
            rating: Int = RandomHelper.randomInt(),
            ratingState: String = "good",
            isModified: Boolean = RandomHelper.randomBoolean(),
            likesCount: Int = RandomHelper.randomInt(),
            commentsCount: Int = RandomHelper.randomInt(),
            createdAt: Date = RandomHelper.randomDate(),
            user: com.kgmyshin.record.infra.api.json.UserJson = com.kgmyshin.record.infra.api.json.UserJsonFactory.create(),
            work: com.kgmyshin.annict.workDictionary.infra.api.json.WorkJson = WorkJsonFactory.create(),
            episode: com.kgmyshin.annict.workDictionary.infra.api.json.EpisodeJson = EpisodeJsonFactory.create()
    ): RecordJson = com.kgmyshin.record.infra.api.json.RecordJson(id, comment, rating, ratingState, isModified, likesCount, commentsCount, createdAt, user, work, episode)
}
