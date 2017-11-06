package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.random.RandomHelper
import kotlin.Int
import kotlin.String

object EpisodeJsonFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      number: Int = RandomHelper.randomInt(),
      numberText: String = RandomHelper.randomString(),
      sortNumber: Int = RandomHelper.randomInt(),
      title: String = RandomHelper.randomString(),
      recordsCount: Int = RandomHelper.randomInt(),
      recordCommentsCount: Int = RandomHelper.randomInt(),
      workJson: com.kgmyshin.workDictionary.infra.api.json.WorkJson = com.kgmyshin.workDictionary.infra.api.json.WorkJsonFactory.create(),
      prevEpisodeJson: com.kgmyshin.workDictionary.infra.api.json.PrevEpisodeJson = com.kgmyshin.workDictionary.infra.api.json.PrevEpisodeJsonFactory.create(),
      nextEpisodeJson: com.kgmyshin.workDictionary.infra.api.json.NextEpisodeJson = com.kgmyshin.workDictionary.infra.api.json.NextEpisodeJsonFactory.create()
  ): EpisodeJson = com.kgmyshin.workDictionary.infra.api.json.EpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount, workJson, prevEpisodeJson, nextEpisodeJson)
}
