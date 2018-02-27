package com.kgmyshin.annict.auth.usecase.impl

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.domain.AccessTokenRepository
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAccessTokenUseCaseImplTest {

    @Mock
    private lateinit var repository: AccessTokenRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val accessToken = AccessToken("accessToken")
        Mockito.`when`(repository.find()).thenReturn(Maybe.just(accessToken))

        // when
        val useCase = GetAccessTokenUseCaseImpl(repository)
        val maybe = useCase.execute()

        // then
        maybe.test().await().assertValue(accessToken).assertComplete()
    }

}