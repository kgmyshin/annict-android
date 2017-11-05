package com.kgmyshin.workDictionary.ui.work

import com.kgmyshin.workDictionary.domain.work.Work

internal object WorkViewModelConverter {

    fun convertToViewModel(workList: List<Work>): List<WorkViewModel> =
            workList.map { convertToViewModel(it) }

    fun convertToViewModel(work: Work): WorkViewModel =
            WorkViewModel(
                    id = work.id.value,
                    title = work.title,
                    titleKana = work.titleKana,
                    season = SeasonViewModelConverter.convertToViewModel(work.season),
                    officialSiteUrl = work.officialSiteUrl,
                    twitterUserName = work.twitterUserName,
                    imageUrl = work.imageUrl,
                    episodesCount = work.episodesCount,
                    watchersCount = work.watchersCount
            )

}