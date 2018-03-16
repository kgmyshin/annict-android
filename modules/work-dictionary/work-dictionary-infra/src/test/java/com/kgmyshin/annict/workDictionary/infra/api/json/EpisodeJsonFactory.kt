package com.kgmyshin.annict.workDictionary.infra.api.json

import com.kgmyshin.common.random.RandomHelper

internal object EpisodeJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            number: Int = RandomHelper.randomInt(),
            numberText: String = RandomHelper.randomString(),
            sortNumber: Int = RandomHelper.randomInt(),
            title: String = RandomHelper.randomString(),
            recordsCount: Int = RandomHelper.randomInt(),
            recordCommentsCount: Int = RandomHelper.randomInt(),
            workJson: WorkJson = WorkJsonFactory.create(),
            prevEpisodeJson: PrevEpisodeJson = PrevEpisodeJsonFactory.create(),
            nextEpisodeJson: NextEpisodeJson = NextEpisodeJsonFactory.create()
    ): EpisodeJson = EpisodeJson(id, number, numberText, sortNumber, title, recordsCount, recordCommentsCount, workJson, prevEpisodeJson, nextEpisodeJson)
}
