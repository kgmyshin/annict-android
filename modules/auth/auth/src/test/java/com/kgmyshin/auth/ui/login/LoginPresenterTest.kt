package com.kgmyshin.auth.ui.login

import android.content.Context
import com.kgmyshin.annict.auth.ui.login.LoginContract
import com.kgmyshin.annict.auth.ui.login.LoginPresenter
import com.kgmyshin.annict.auth.ui.login.ScreenTransition
import com.kgmyshin.annict.auth.usecase.AuthorizeUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoginPresenterTest {

    @Mock
    private lateinit var authorizeUseCase: AuthorizeUseCase
    @Mock
    private lateinit var errorHandler: ErrorHandler
    @Mock
    private lateinit var view: LoginContract.View
    @Mock
    private lateinit var screenTransition: ScreenTransition
    @Mock
    private lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testOnCreateView() {
        // given
        // nothing

        // when
        val presenter = LoginPresenter(
                authorizeUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition
        )
        presenter.onCreateView()

        // then
        Mockito.verify(view).load("https://api.annict.com/oauth/authorize?client_id=${com.kgmyshin.annict.auth.infra.BuildConfig.ANNICT_CLIENT_ID}&response_type=code&redirect_uri=${com.kgmyshin.annict.auth.infra.BuildConfig.ANNICT_CALLBACK}&scope=read write")
    }

    @Test
    fun testOnLoad() {
        // given
        val loginCompletedUrl = "https://kgmyshin.com/annict?code=123456789abcdefg#_=_"
        Mockito.`when`(authorizeUseCase.execute("123456789abcdefg")).thenReturn(Completable.complete())

        // when
        val presenter = LoginPresenter(
                authorizeUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition
        )
        presenter.onLoaded(loginCompletedUrl)

        // then
        Mockito.verify(view).showProgress()
        Mockito.verify(authorizeUseCase).execute("123456789abcdefg")
        Mockito.verify(screenTransition).moveToHome()
        Mockito.verify(view).dismissProgress()
    }

    @Test
    fun testOnLoad_ThrowRuntimeException() {
        // given
        val loginCompletedUrl = "https://kgmyshin.com/annict?code=123456789abcdefg#_=_"
        val exception = RuntimeException()
        Mockito.`when`(authorizeUseCase.execute("123456789abcdefg")).thenReturn(Completable.error(exception))
        Mockito.`when`(view.getContext()).thenReturn(context)

        // when
        val presenter = LoginPresenter(
                authorizeUseCase,
                Schedulers.trampoline(),
                errorHandler
        )
        presenter.setUp(
                view,
                screenTransition
        )
        presenter.onLoaded(loginCompletedUrl)

        // then
        Mockito.verify(view).showProgress()
        Mockito.verify(errorHandler).showDialog(
                context,
                exception,
                null
        )
        Mockito.verify(view).dismissProgress()
    }

}