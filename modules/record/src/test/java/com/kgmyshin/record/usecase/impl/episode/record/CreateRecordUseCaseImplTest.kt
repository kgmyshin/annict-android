package com.kgmyshin.record.usecase.impl.episode.record

import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.episode.record.RecordRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CreateRecordUseCaseImplTest {

    @Mock
    private lateinit var repository: RecordRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val record = DomainHelper.record()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        Mockito.`when`(repository.create(
                record,
                shareTwitter,
                shareFacebook
        )).thenReturn(Single.just(record))

        // when
        val useCase = CreateRecordUseCaseImpl(repository)
        val completable = useCase.execute(
                record,
                shareTwitter,
                shareFacebook
        )

        // then
        completable.test().await().assertComplete()
    }

}