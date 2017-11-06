package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper
import kotlin.Int
import kotlin.String

object PrevEpisodeJsonFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      number: Int = RandomHelper.randomInt(),
      numberText: String = RandomHelper.randomString(),
      sortNumber: Int = RandomHelper.randomInt(),
      title: String = RandomHelper.randomString(),
      recordsCount: Int = RandomHelper.randomInt(),
      recordCommentsCount: Int = RandomHelper.randomInt()
  ): PrevEpisodeJson = com.kgmyshin.workDictionary.infra.api.json.PrevEpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount)
}
