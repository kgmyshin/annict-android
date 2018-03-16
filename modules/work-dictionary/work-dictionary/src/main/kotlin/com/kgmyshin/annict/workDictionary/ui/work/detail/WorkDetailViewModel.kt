package com.kgmyshin.annict.workDictionary.ui.work.detail

import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel

data class WorkDetailViewModel(
        val workViewModel: WorkViewModel,
        val episodeViewModelList: List<EpisodeViewModel>
)