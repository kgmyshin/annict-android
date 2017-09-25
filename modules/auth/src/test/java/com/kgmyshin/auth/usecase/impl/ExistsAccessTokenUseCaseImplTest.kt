package com.kgmyshin.auth.usecase.impl

import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.usecase.impl.ExistsAccessTokenUseCaseImpl
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ExistsAccessTokenUseCaseImplTest {

    @Mock
    private lateinit var repository: AccessTokenRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        Mockito.`when`(repository.exists()).thenReturn(Single.just(true))

        // when
        val useCase = ExistsAccessTokenUseCaseImpl(repository)
        val single = useCase.execute()

        // then
        single.test().await().assertValue(true).assertComplete()
    }

}