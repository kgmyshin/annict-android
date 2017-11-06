package com.kgmyshin.record.infra.api.json

import com.kgmyshin.random.RandomHelper
import java.util.Date
import kotlin.Int
import kotlin.String

object UserJsonFactory {
  fun create(
      id: String = RandomHelper.randomString(),
      username: String = RandomHelper.randomString(),
      description: String = RandomHelper.randomString(),
      url: String = RandomHelper.randomString(),
      avatarUrl: String = RandomHelper.randomString(),
      backgroundImageUrl: String = RandomHelper.randomString(),
      recordsCount: Int = RandomHelper.randomInt(),
      createdAt: Date = RandomHelper.randomDate()
  ): UserJson = com.kgmyshin.record.infra.api.json.UserJson(id, username, description, url, avatarUrl, backgroundImageUrl, recordsCount, createdAt)
}
