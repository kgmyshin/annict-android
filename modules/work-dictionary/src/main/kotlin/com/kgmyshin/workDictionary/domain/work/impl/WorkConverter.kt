package com.kgmyshin.workDictionary.domain.work.impl

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.infra.api.json.EpisodeJson
import com.kgmyshin.workDictionary.infra.api.json.WorkJson

internal object WorkConverter {

    fun convertToDomainModel(pair: Pair<WorkJson, List<EpisodeJson>>): Work {
        TODO("aaa")
    }

}