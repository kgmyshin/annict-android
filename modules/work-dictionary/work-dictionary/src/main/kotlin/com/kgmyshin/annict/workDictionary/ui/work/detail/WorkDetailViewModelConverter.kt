package com.kgmyshin.annict.workDictionary.ui.work.detail

import com.kgmyshin.annict.workDictionary.domain.work.Work
import com.kgmyshin.annict.workDictionary.domain.work.episode.Episode
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModelConverter

internal object WorkDetailViewModelConverter {

    fun convertToViewModel(
            work: Work,
            episodeList: List<Episode>
    ): WorkDetailViewModel = WorkDetailViewModel(
            WorkBindingModelConverter.convertToViewModel(work),
            EpisodeViewModelConverter.convertToViewModel(episodeList)
    )

}