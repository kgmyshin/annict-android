package com.kgmyshin.auth.ui.login

import com.kgmyshin.auth.BuildConfig
import java.util.regex.Pattern

class LoginPresenter : LoginContract.Presenter {

    companion object {
        private val LOGIN_URL = "https://annict.jp/sign_in?back=%2Foauth%2Fauthorize%3Fclient_id%3D${BuildConfig.ANNICT_CLIENT_ID}%26response_type%3Dcode%26redirect_uri%3Durn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob%26scope%3Dread%2Bwrite"
        private val LOGIN_COMPLETE_URL_PATTERN = "https://annict.jp/oauth/authorize/(.*)"

    }

    private lateinit var view: LoginContract.View
    private lateinit var screenTransition: LoginContract.ScreenTransition

    override fun setUp(
            view: LoginContract.View,
            screenTransition: LoginContract.ScreenTransition
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
        if (isLoginCompleted(url)) {
            // TODO: codeを使ってトークン取得
            extractAuthCode(url)
        }
    }

    override fun onDetach() {

    }

    private fun isLoginCompleted(url: String): Boolean {
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