package com.kgmyshin.record.domain.impl.episode.record

import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.RatingState
import com.kgmyshin.record.domain.episode.record.Record
import com.kgmyshin.record.domain.episode.record.RecordId
import com.kgmyshin.record.domain.impl.user.UserConverter
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.infra.api.json.RecordJson

internal object RecordConverter {

    fun convertToRecord(listJson: List<RecordJson>): List<Record> = listJson.map { convertToRecord(it) }

    fun convertToRecord(json: RecordJson): Record =
            Record(
                    id = RecordId(json.id),
                    comment = json.comment,
                    ratingState = RatingState.rawValueOf(json.ratingState),
                    isModified = json.isModified,
                    likesCount = json.likesCount,
                    commentsCount = json.commentsCount,
                    user = UserConverter.convertToUser(json.user),
                    workId = WorkId(json.work.id),
                    episodeId = EpisodeId(json.episode.id)
            )

}