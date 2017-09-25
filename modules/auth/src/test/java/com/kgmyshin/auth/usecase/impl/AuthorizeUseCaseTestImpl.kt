package com.kgmyshin.auth.usecase.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.domain.AccessTokenRepository
import com.kgmyshin.auth.domain.AuthorizeService
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AuthorizeUseCaseTestImpl {

    @Mock
    private lateinit var authorizeService: AuthorizeService
    @Mock
    private lateinit var accessTokenRepository: AccessTokenRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val code = "code"
        val accessToken = AccessToken("accessToken")
        Mockito.`when`(authorizeService.execute(code)).thenReturn(Single.just(accessToken))
        Mockito.`when`(accessTokenRepository.store(accessToken)).thenReturn(Completable.complete())

        // when
        val useCase = AuthorizeUseCaseImpl(
                authorizeService,
                accessTokenRepository
        )
        val completable = useCase.execute(code)

        // then
        completable.test().await().assertComplete()
    }


}