package com.kgmyshin.record.usecase.impl.episode.record

import com.kgmyshin.record.domain.episode.record.Record
import com.kgmyshin.record.domain.episode.record.RecordRepository
import com.kgmyshin.record.usecase.episode.record.CreateRecordUseCase
import io.reactivex.Completable

internal class CreateRecordUseCaseImpl(private val repository: RecordRepository) : CreateRecordUseCase {

    override fun execute(
            record: Record,
            shareTwitter: Boolean,
            shareFacebook: Boolean
    ): Completable = repository.create(
            record,
            shareTwitter,
            shareFacebook
    ).toCompletable()

}