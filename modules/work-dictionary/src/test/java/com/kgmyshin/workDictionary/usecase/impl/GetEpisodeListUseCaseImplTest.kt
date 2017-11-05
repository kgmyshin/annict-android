package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.episode.EpisodeRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetEpisodeListUseCaseImplTest {

    @Mock
    private lateinit var repository: EpisodeRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val episodeList = listOf(
                DomainHelper.episode(),
                DomainHelper.episode(),
                DomainHelper.episode()
        )
        Mockito.`when`(repository.findAllByWorkId(workId)).thenReturn(Single.just(episodeList))

        // when
        val useCase = GetEpisodeListUseCaseImpl(repository)
        val single = useCase.execute(workId)

        // then
        single.test().await().assertValue(episodeList).assertComplete()
    }

}