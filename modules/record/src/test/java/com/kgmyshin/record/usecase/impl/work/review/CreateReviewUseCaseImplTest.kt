package com.kgmyshin.record.usecase.impl.work.review

import com.kgmyshin.random.RandomHelper
import com.kgmyshin.record.domain.DomainHelper
import com.kgmyshin.record.domain.work.review.ReviewRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CreateReviewUseCaseImplTest {

    @Mock
    private lateinit var repository: ReviewRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val review = DomainHelper.review()
        val shareTwitter = RandomHelper.randomBoolean()
        val shareFacebook = RandomHelper.randomBoolean()
        Mockito.`when`(repository.create(
                review,
                shareTwitter,
                shareFacebook
        )).thenReturn(Single.just(review))

        // when
        val useCase = CreateReviewUseCaseImpl(repository)
        val completable = useCase.execute(
                review,
                shareTwitter,
                shareFacebook
        )

        // then
        completable.test().await().assertComplete()
    }

}