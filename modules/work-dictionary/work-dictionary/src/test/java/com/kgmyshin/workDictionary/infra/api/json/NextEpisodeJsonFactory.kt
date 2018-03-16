package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper
import kotlin.Int
import kotlin.String

internal object NextEpisodeJsonFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      number: Int = RandomHelper.randomInt(),
      numberText: String = RandomHelper.randomString(),
      sortNumber: Int = RandomHelper.randomInt(),
      title: String = RandomHelper.randomString(),
      recordsCount: Int = RandomHelper.randomInt(),
      recordCommentsCount: Int = RandomHelper.randomInt()
  ): NextEpisodeJson = com.kgmyshin.workDictionary.infra.api.json.NextEpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount)
}
