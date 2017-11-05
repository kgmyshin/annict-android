package com.kgmyshin.workDictionary.domain

import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.Episode
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeId

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