package com.kgmyshin.annict.workDictionary.infra.api.json

import com.kgmyshin.common.random.RandomHelper

internal object WorkJsonFactory {
    fun create(
            id: String = RandomHelper.randomString(),
            title: String = RandomHelper.randomString(),
            titleKana: String = RandomHelper.randomString(),
            media: String = RandomHelper.randomString(),
            mediaText: String = RandomHelper.randomString(),
            seasonName: String = RandomHelper.randomString(),
            seasonNameText: String = RandomHelper.randomString(),
            releasedOn: String = RandomHelper.randomString(),
            releasedOnAbout: String = RandomHelper.randomString(),
            officialSiteUrl: String = RandomHelper.randomString(),
            wikipediaUrl: String = RandomHelper.randomString(),
            twitterUserName: String = RandomHelper.randomString(),
            twitterHashTag: String = RandomHelper.randomString(),
            imagesJson: ImagesJson = com.kgmyshin.annict.workDictionary.infra.api.json.ImagesJsonFactory.create(),
            episodeCount: Int = RandomHelper.randomInt(),
            watchersCount: Int = RandomHelper.randomInt(),
            reviewsCount: Int = RandomHelper.randomInt(),
            noEpisodes: Boolean = RandomHelper.randomBoolean()
    ): WorkJson = WorkJson(id, title, titleKana, media, mediaText, seasonName, seasonNameText, releasedOn, releasedOnAbout, officialSiteUrl, wikipediaUrl, twitterUserName, twitterHashTag, imagesJson, episodeCount, watchersCount, reviewsCount, noEpisodes)
}
