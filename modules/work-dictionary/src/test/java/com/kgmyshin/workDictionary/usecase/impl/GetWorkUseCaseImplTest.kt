package com.kgmyshin.workDictionary.usecase.impl

import com.kgmyshin.random.RandomHelper
import com.kgmyshin.workDictionary.domain.DomainHelper
import com.kgmyshin.workDictionary.domain.work.WorkId
import com.kgmyshin.workDictionary.domain.work.WorkRepository
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetWorkUseCaseImplTest {

    @Mock
    private lateinit var repository: WorkRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val work = DomainHelper.work()
        Mockito.`when`(repository.find(workId)).thenReturn(Maybe.just(work))

        // when
        val useCase = GetWorkUseCaseImpl(repository)
        val maybe = useCase.execute(workId)

        // then
        maybe.test().await().assertValue(work).assertComplete()
    }

}
