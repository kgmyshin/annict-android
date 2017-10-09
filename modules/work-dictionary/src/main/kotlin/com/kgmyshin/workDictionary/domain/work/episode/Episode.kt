package com.kgmyshin.workDictionary.domain.work.episode

import com.kgmyshin.common.dddSupport.Entity

internal class Episode(
        id: EpisodeId,
        number: Int,
        title: String
) : Entity<EpisodeId>(id)