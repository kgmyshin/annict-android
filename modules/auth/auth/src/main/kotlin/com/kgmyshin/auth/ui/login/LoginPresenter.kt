package com.kgmyshin.auth.ui.login

import com.kgmyshin.auth.BuildConfig
import com.kgmyshin.auth.usecase.AuthorizeUseCase
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
        private const val LOGIN_URL = "https://annict.jp/sign_in?back=%2Foauth%2Fauthorize%3Fclient_id%3D${BuildConfig.ANNICT_CLIENT_ID}%26response_type%3Dcode%26redirect_uri%3Durn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob%26scope%3Dread%2Bwrite"
        private const val LOGIN_COMPLETE_URL_PATTERN = "https://(jp.annict.com|annict.jp)/oauth/authorize/(.*)(#_=_)?"

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

    override fun onLoaded(url: String) {
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
                    },
                            { throwable ->
                                errorHandler.showDialog(
                                        view.getContext(),
                                        throwable,
                                        null
                                )
                                view.dismissProgress()
                            })
                    .addTo(disposables)
        }
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
            return m.group(1)
        } else {
            throw IllegalArgumentException("can't extract code from $url")
        }
    }

}