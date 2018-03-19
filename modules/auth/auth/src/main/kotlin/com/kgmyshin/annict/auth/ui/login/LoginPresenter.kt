package com.kgmyshin.annict.auth.ui.login

import com.kgmyshin.annict.auth.infra.BuildConfig
import com.kgmyshin.annict.auth.usecase.AuthorizeUseCase
import com.kgmyshin.common.errorHandler.ErrorHandler
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Named

internal class LoginPresenter @Inject constructor(
        private val authorizeUseCase: AuthorizeUseCase,
        @Named("ui") private val uiScheduler: Scheduler,
        private val errorHandler: ErrorHandler
) : LoginContract.Presenter {

    companion object {
        private const val LOGIN_URL = "https://api.annict.com/oauth/authorize?client_id=${BuildConfig.ANNICT_CLIENT_ID}&response_type=code&redirect_uri=${BuildConfig.ANNICT_CALLBACK}&scope=read write"
        private const val LOGIN_COMPLETE_URL_PATTERN = "https://kgmyshin\\.com/annict\\?code=(.*)(#_=_)?"
    }

    private lateinit var view: LoginContract.View
    private lateinit var screenTransition: ScreenTransition
    private val disposables = CompositeDisposable()

    override fun setUp(
            view: LoginContract.View,
            screenTransition: ScreenTransition
    ) {
        this.view = view
        this.screenTransition = screenTransition
    }

    override fun onCreateView() {
        view.load(LOGIN_URL)
    }

    override fun onAttach() {
    }

    override fun onLoaded(url: String): Boolean {
        if (isLoginCompletedUrl(url)) {
            val code = extractAuthCode(url)
            authorizeUseCase.execute(code)
                    .doOnSubscribe {
                        view.showProgress()
                    }
                    .observeOn(uiScheduler)
                    .subscribe({
                        screenTransition.moveToHome()
                        view.dismissProgress()
                    }, { throwable ->
                        view.getContext()?.let {
                            errorHandler.showDialog(
                                    it,
                                    throwable,
                                    null
                            )
                        }
                        view.dismissProgress()
                    })
                    .addTo(disposables)
            return true
        }
        return false
    }

    override fun onDetach() {
        disposables.clear()
    }

    private fun isLoginCompletedUrl(url: String): Boolean {
        val p = Pattern.compile(LOGIN_COMPLETE_URL_PATTERN)
        val m = p.matcher(url)
        return m.find()
    }

    private fun extractAuthCode(url: String): String {
        val p = Pattern.compile(LOGIN_COMPLETE_URL_PATTERN)
        val m = p.matcher(url)
        if (m.find()) {
            return m.group(1).replace("#_=_", "")
        } else {
            throw IllegalArgumentException("can't extract code from $url")
        }
    }

}