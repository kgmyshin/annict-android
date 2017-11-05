package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.domain.work.Season
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetBeforeSeasonWorkListUseCaseImplTest {

    @Mock
    private lateinit var repository: WorkRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val workList = listOf(
                DomainHelper.work(),
                DomainHelper.work(),
                DomainHelper.work()
        )
        Mockito.`when`(repository.findAllBySeason(Season.beforeSeason())).thenReturn(Single.just(workList))

        // when
        val useCase = GetBeforeSeasonWorkListUseCaseImpl(repository)
        val single = useCase.execute()

        // then
        single.test().await().assertValue(workList).assertComplete()
    }


}