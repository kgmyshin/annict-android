package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.workDictionary.domain.work.Work
import com.kgmyshin.workDictionary.domain.work.episode.Episode
import com.kgmyshin.workDictionary.ui.work.WorkViewModelConverter

internal object WorkDetailViewModelConverter {

    fun convertToViewModel(
            work: Work,
            episodeList: List<Episode>
    ): WorkDetailViewModel = WorkDetailViewModel(
            WorkViewModelConverter.convertToViewModel(work),
            EpisodeViewModelConverter.convertToViewModel(episodeList)
    )

}