package com.kgmyshin.annict.workDictionary.domain.work.episode

import com.kgmyshin.common.dddSupport.Entity

class Episode(
        id: EpisodeId,
        val number: Int,
        val title: String
) : Entity<EpisodeId>(id)