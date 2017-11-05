package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.workDictionary.ui.work.WorkViewModel

data class WorkDetailViewModel(
        val workViewModel: WorkViewModel,
        val episodeViewModelList: List<EpisodeViewModel>
)