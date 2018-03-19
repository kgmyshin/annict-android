package com.kgmyshin.workDictionary.infra.api.json

import com.kgmyshin.annict.workDictionary.infra.api.json.PrevEpisodeJson
import com.kgmyshin.common.random.RandomHelper

object PrevEpisodeJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            number: Int = RandomHelper.randomInt(),
            numberText: String = RandomHelper.randomString(),
            sortNumber: Int = RandomHelper.randomInt(),
            title: String = RandomHelper.randomString(),
            recordsCount: Int = RandomHelper.randomInt(),
            recordCommentsCount: Int = RandomHelper.randomInt()
    ): PrevEpisodeJson = com.kgmyshin.annict.workDictionary.infra.api.json.PrevEpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount)
}
