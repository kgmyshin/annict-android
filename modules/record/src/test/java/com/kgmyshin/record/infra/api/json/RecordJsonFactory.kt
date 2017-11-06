package com.kgmyshin.record.infra.api.json

import com.kgmyshin.random.RandomHelper
import java.util.Date
import kotlin.Boolean
import kotlin.Int
import kotlin.String

object RecordJsonFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      comment: String = RandomHelper.randomString(),
      rating: Int = RandomHelper.randomInt(),
      ratingState: String = RandomHelper.randomString(),
      isModified: Boolean = RandomHelper.randomBoolean(),
      likesCount: Int = RandomHelper.randomInt(),
      commentsCount: Int = RandomHelper.randomInt(),
      createdAt: Date = RandomHelper.randomDate(),
      user: com.kgmyshin.record.infra.api.json.UserJson = com.kgmyshin.record.infra.api.json.UserJsonFactory.create(),
      work: com.kgmyshin.workDictionary.infra.api.json.WorkJson = com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(),
      episode: com.kgmyshin.workDictionary.infra.api.json.EpisodeJson = com.kgmyshin.workDictionary.infra.api.json.EpisodeJsonFactory.create()
  ): RecordJson = com.kgmyshin.record.infra.api.json.RecordJson(id, comment, rating, ratingState, isModified, likesCount, commentsCount, createdAt, user, work, episode)
}
