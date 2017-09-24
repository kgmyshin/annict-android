package com.kgmyshin.auth.infra.localStore

import com.kgmyshin.auth.infra.localStore.impl.AccessTokenLocalStoreImpl
import com.kgmyshin.auth.infra.pref.AccessTokenPreference
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class AccessTokenLocalStoreTest {

    @Mock
    private lateinit var accessTokenPreference: AccessTokenPreference

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGet() {
        // given
        val accessToken: String = "accessToken"
        Mockito.`when`(accessTokenPreference.get()).thenReturn(accessToken)

        // when
        val accessTokenLocalStore = AccessTokenLocalStoreImpl(accessTokenPreference)
        val maybe = accessTokenLocalStore.get()

        // then
        maybe.test().await().assertValue(accessToken).assertComplete()
    }

    @Test
    fun testPut() {
        // given
        val newAccessToken = "newAccessToken"

        // when
        val accessTokenLocalStore = AccessTokenLocalStoreImpl(accessTokenPreference)
        val completable = accessTokenLocalStore.put(newAccessToken)

        // then
        completable.test().await().assertComplete()
        Mockito.verify(accessTokenPreference).put(newAccessToken)
    }

}