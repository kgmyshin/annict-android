package com.kgmyshin.workDictionary.domain.work.episode

import com.kgmyshin.common.dddSupport.Entity

internal class Episode(
        id: EpisodeId,
        val number: Int,
        val title: String
) : Entity<EpisodeId>(id)