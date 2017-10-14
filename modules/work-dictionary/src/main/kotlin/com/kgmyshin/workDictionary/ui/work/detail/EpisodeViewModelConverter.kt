package com.kgmyshin.workDictionary.ui.work.detail

import com.kgmyshin.workDictionary.domain.work.episode.Episode

internal object EpisodeViewModelConverter {

    fun convertToViewModel(episodeList: List<Episode>): List<EpisodeViewModel> =
            episodeList.map { convertToViewModel(it) }

    fun convertToViewModel(episode: Episode): EpisodeViewModel = EpisodeViewModel(
            number = episode.number,
            title = episode.title
    )

}