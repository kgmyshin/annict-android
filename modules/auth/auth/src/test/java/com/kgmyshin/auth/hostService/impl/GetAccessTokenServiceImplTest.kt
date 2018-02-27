package com.kgmyshin.auth.hostService.impl

import com.kgmyshin.annict.auth.domain.AccessToken
import com.kgmyshin.annict.auth.hostService.impl.GetAccessTokenServiceImpl
import com.kgmyshin.annict.auth.usecase.GetAccessTokenUseCase
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAccessTokenServiceImplTest {

    @Mock
    private lateinit var useCase: GetAccessTokenUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val accessToken = AccessToken("accessToken")
        Mockito.`when`(useCase.execute()).thenReturn(Maybe.just(accessToken))

        // when
        val service = GetAccessTokenServiceImpl(useCase)
        val maybe = service.execute()

        // then
        maybe.test().await().assertValue(accessToken.value).assertComplete()
    }

}