package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.NextEpisodeJson
import com.kgmyshin.random.RandomHelper

object NextEpisodeJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            number: Int = RandomHelper.randomInt(),
            numberText: String = RandomHelper.randomString(),
            sortNumber: Int = RandomHelper.randomInt(),
            title: String = RandomHelper.randomString(),
            recordsCount: Int = RandomHelper.randomInt(),
            recordCommentsCount: Int = RandomHelper.randomInt()
    ): NextEpisodeJson = com.kgmyshin.annict.workDictionary.infra.api.json.NextEpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount)
}
