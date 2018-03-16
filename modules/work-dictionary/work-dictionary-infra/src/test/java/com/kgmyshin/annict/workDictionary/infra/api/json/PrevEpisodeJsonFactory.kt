package com.kgmyshin.annict.workDictionary.infra.api.json

import com.kgmyshin.common.random.RandomHelper

internal object PrevEpisodeJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            number: Int = RandomHelper.randomInt(),
            numberText: String = RandomHelper.randomString(),
            sortNumber: Int = RandomHelper.randomInt(),
            title: String = RandomHelper.randomString(),
            recordsCount: Int = RandomHelper.randomInt(),
            recordCommentsCount: Int = RandomHelper.randomInt()
    ): PrevEpisodeJson = PrevEpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount)
}
