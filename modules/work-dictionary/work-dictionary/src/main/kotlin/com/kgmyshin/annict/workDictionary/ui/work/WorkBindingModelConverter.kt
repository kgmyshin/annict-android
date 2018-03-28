package com.kgmyshin.annict.workDictionary.ui.work

import com.kgmyshin.annict.workDictionary.domain.work.Work

internal object WorkBindingModelConverter {

    fun convertToViewModel(workList: List<Work>): List<WorkBindingModel> =
            workList.map { convertToViewModel(it) }

    fun convertToViewModel(work: Work): WorkBindingModel =
            WorkBindingModel(
                    id = work.id.value,
                    title = work.title,
                    titleKana = work.titleKana,
                    season = work.season?.let { SeasonBindingModelConverter.convertToViewModel(it) },
                    officialSiteUrl = work.officialSiteUrl,
                    twitterUserName = work.twitterUserName,
                    imageUrl = work.imageUrl,
                    episodesCount = work.episodesCount,
                    watchersCount = work.watchersCount
            )

}