package com.kgmyshin.record.usecase.impl.episode.record

import com.kgmyshin.common.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.episode.EpisodeId
import com.kgmyshin.record.domain.episode.record.RecordRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetRecordListUseCaseImplTest {

    @Mock
    private lateinit var repository: RecordRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val episodeId = EpisodeId(RandomHelper.randomString())
        val recordList = listOf(
                DomainHelper.record(),
                DomainHelper.record(),
                DomainHelper.record()
        )
        Mockito.`when`(repository.findByEpisodeId(episodeId)).thenReturn(Single.just(recordList))

        // when
        val useCase = GetRecordListUseCaseImpl(repository)
        val single = useCase.execute(episodeId)

        // then
        single.test().await().assertValue(recordList).assertComplete()
    }

}