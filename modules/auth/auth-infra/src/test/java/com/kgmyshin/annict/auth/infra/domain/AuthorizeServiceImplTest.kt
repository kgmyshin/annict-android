package com.kgmyshin.auth.domain.impl

import com.kgmyshin.annict.auth.infra.api.AuthApiClient
import com.kgmyshin.annict.auth.infra.api.json.PublishTokenRequestJson
import com.kgmyshin.annict.auth.infra.api.json.PublishTokenResponseJson
import com.kgmyshin.annict.auth.infra.domain.AccessTokenConverter
import com.kgmyshin.annict.auth.infra.domain.AuthorizeServiceImpl
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AuthorizeServiceImplTest {

    @Mock
    private lateinit var apiClient: AuthApiClient
    private val scheduler = Schedulers.trampoline()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExecute() {
        // given
        val code = "code"
        val responseJson = PublishTokenResponseJson(
                accessToken = "accessToken",
                tokenType = "tokenType",
                scope = "scope",
                createdAt = 1000
        )
        Mockito.`when`(apiClient.publishToken(PublishTokenRequestJson(code))).thenReturn(
                Single.just(responseJson)
        )

        // when
        val service = AuthorizeServiceImpl(
                apiClient,
                scheduler
        )
        val single = service.execute(code)

        // then
        val expected = AccessTokenConverter.convertToDomainModel(responseJson)
        single.test().await().assertValue(expected).assertComplete()
    }
}