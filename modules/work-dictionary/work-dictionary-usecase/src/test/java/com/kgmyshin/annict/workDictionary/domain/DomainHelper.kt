package com.kgmyshin.annict.workDictionary.domain

import com.kgmyshin.annict.workDictionary.domain.work.Season
import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.WorkId
import com.kgmyshin.annict.workDictionary.domain.work.episode.Episode
import com.kgmyshin.annict.workDictionary.domain.work.episode.EpisodeId
import com.kgmyshin.common.random.RandomHelper


internal object DomainHelper {

    fun work(): Work = Work(
            WorkId(RandomHelper.randomString()),
            RandomHelper.randomString(),
            RandomHelper.randomString(),
            Season(RandomHelper.randomString()),
            RandomHelper.randomString(),
            RandomHelper.randomString(),
            RandomHelper.randomString(),
            RandomHelper.randomInt(),
            RandomHelper.randomInt()
    )

    fun episode(): Episode = Episode(
            EpisodeId(RandomHelper.randomString()),
            RandomHelper.randomInt(),
            RandomHelper.randomString()
    )

}