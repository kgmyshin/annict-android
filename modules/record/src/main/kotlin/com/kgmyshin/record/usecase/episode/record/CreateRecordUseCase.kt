package com.kgmyshin.record.usecase.episode.record

import com.kgmyshin.record.domain.episode.record.Record
import io.reactivex.Completable

internal interface CreateRecordUseCase {

    fun execute(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Completable

}