package com.kgmyshin.record.domain.episode.record

import com.kgmyshin.common.dddSupport.Entity
import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.user.User
import com.kgmyshin.record.domain.work.WorkId

internal class Record(
        id: RecordId,
        val comment: String,
        val ratingState: RatingState,
        val isModified: Boolean,
        val likesCount: Int = 0,
        val commentsCount: Int = 0,
        val user: User,
        val workId: WorkId,
        val episodeId: EpisodeId
) : Entity<RecordId>(id)