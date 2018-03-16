package com.kgmyshin.workDictionary.ui.work.detail

object WorkDetailViewModelFactory {
  fun create(workViewModel: com.kgmyshin.workDictionary.ui.work.WorkViewModel = com.kgmyshin.workDictionary.ui.work.WorkViewModelFactory.create(), episodeViewModelList: List<com.kgmyshin.workDictionary.ui.work.detail.EpisodeViewModel> = listOf(com.kgmyshin.workDictionary.ui.work.detail.EpisodeViewModelFactory.create(), com.kgmyshin.workDictionary.ui.work.detail.EpisodeViewModelFactory.create(), com.kgmyshin.workDictionary.ui.work.detail.EpisodeViewModelFactory.create())): WorkDetailViewModel = com.kgmyshin.workDictionary.ui.work.detail.WorkDetailViewModel(workViewModel, episodeViewModelList)
}
