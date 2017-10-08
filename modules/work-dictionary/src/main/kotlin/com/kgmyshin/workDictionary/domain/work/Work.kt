package com.kgmyshin.workDictionary.domain.work

import com.kgmyshin.common.dddSupport.Entity
import com.kgmyshin.workDictionary.domain.work.episode.Episode

internal class Work(
        id: WorkId,
        val episodeList: List<Episode>
) : Entity<WorkId>(id)