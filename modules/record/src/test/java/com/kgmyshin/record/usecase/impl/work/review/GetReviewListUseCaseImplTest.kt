package com.kgmyshin.record.usecase.impl.work.review

import com.kgmyshin.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.work.WorkId
import com.kgmyshin.record.domain.work.review.ReviewRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetReviewListUseCaseImplTest {

    @Mock
    private lateinit var repository: ReviewRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val workId = WorkId(RandomHelper.randomString())
        val reviewList = listOf(
                DomainHelper.review(),
                DomainHelper.review(),
                DomainHelper.review()
        )
        Mockito.`when`(repository.findByWorkId(workId)).thenReturn(Single.just(reviewList))

        // when
        val useCase = GetReviewListUseCaseImpl(repository)
        val single = useCase.execute(workId)

        // then
        single.test().await().assertValue(reviewList).assertComplete()
    }


}