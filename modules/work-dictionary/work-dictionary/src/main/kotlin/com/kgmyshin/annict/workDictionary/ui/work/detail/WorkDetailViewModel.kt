package com.kgmyshin.annict.workDictionary.ui.work.detail

import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel

data class WorkDetailViewModel(
        val workBindingModel: WorkBindingModel,
        val episodeViewModelList: List<EpisodeViewModel>
)