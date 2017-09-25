package com.kgmyshin.auth.hostService.impl

import com.kgmyshin.auth.usecase.ExistsAccessTokenUseCase
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ExistsAccessTokenServiceImplTest {

    @Mock
    private lateinit var useCase: ExistsAccessTokenUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        Mockito.`when`(useCase.execute()).thenReturn(Single.just(true))

        // when
        val service = ExistsAccessTokenServiceImpl(useCase)
        val single = service.execute()

        // then
        single.test().await().assertValue(true).assertComplete()
    }

}