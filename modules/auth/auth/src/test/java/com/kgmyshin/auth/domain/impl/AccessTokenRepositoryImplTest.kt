package com.kgmyshin.auth.domain.impl

import com.kgmyshin.auth.domain.AccessToken
import com.kgmyshin.auth.infra.localStore.AccessTokenLocalStore
import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AccessTokenRepositoryImplTest {

    @Mock
    private lateinit var accessTokenLocalStore: AccessTokenLocalStore

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testExists() {
        // given
        Mockito.`when`(accessTokenLocalStore.get()).thenReturn(Maybe.just("accessToken"))

        // when
        val repository = AccessTokenRepositoryImpl(accessTokenLocalStore)
        val single = repository.exists()

        // then
        single.test().await().assertValue(true).assertComplete()
    }

    @Test
    fun testExists_NotFoundAccessToken() {
        // given
        Mockito.`when`(accessTokenLocalStore.get()).thenReturn(Maybe.empty())

        // when
        val repository = AccessTokenRepositoryImpl(accessTokenLocalStore)
        val single = repository.exists()

        // then
        single.test().await().assertValue(false).assertComplete()
    }

    @Test
    fun testFind() {
        // given
        val accessToken = "accessToken"
        Mockito.`when`(accessTokenLocalStore.get()).thenReturn(Maybe.just(accessToken))

        // when
        val repository = AccessTokenRepositoryImpl(accessTokenLocalStore)
        val maybe = repository.find()

        // then
        maybe.test().await().assertValue(AccessToken(accessToken)).assertComplete()
    }

    @Test
    fun testStore() {
        // given
        val accessToken = AccessToken("accessToken")
        Mockito.`when`(accessTokenLocalStore.put(accessToken.value)).thenReturn(Completable.complete())

        // when
        val repository = AccessTokenRepositoryImpl(accessTokenLocalStore)
        val completable = repository.store(accessToken)

        // then
        completable.test().await().assertComplete()
        Mockito.verify(accessTokenLocalStore).put(accessToken.value)
    }

}