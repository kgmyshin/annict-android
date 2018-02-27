package com.kgmyshin.annict.auth.ui.login

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.kgmyshin.annict.auth.AuthComponent
import com.kgmyshin.annict.auth.databinding.FragmentLoginBinding
import com.kgmyshin.common.di.ContainerApplicationHelper
import javax.inject.Inject


class LoginFragment : Fragment(), LoginContract.View {

    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject
    internal lateinit var presenter: LoginContract.Presenter

    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ContainerApplicationHelper.get(activity).getComponent(AuthComponent::class).inject(this)
        val screenTransition = (context as? ScreenTransition)
                ?: throw ClassCastException("must cast ScreenTransition")
        presenter.setUp(
                this,
                screenTransition
        )
        presenter.onAttach()
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(
                inflater,
                container,
                false
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()
        } else {
            val cookieSyncMngr = CookieSyncManager.createInstance(context.applicationContext)
            cookieSyncMngr.startSync()
            val cookieManager = CookieManager.getInstance()
            cookieManager.removeAllCookie()
            cookieManager.removeSessionCookie()
            cookieSyncMngr.stopSync()
            cookieSyncMngr.sync()
        }
        binding.webView.clearCache(true)
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.setSupportMultipleWindows(true)
            settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        url: String?
                ): Boolean {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        url?.let { presenter.onLoaded(it) }
                    }
                    return super.shouldOverrideUrlLoading(
                            view,
                            url
                    )
                }

                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                ): Boolean {
                    request?.let { presenter.onLoaded(it.url.toString()) }
                    return super.shouldOverrideUrlLoading(
                            view,
                            request
                    )
                }
            }
            webChromeClient = WebChromeClient()
        }
        presenter.onCreateView()
        return binding.root
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    override fun load(url: String) {
        binding.webView.loadUrl(url)
    }

    override fun dismissProgress() {
        binding.progressContainer.visibility = View.GONE
    }

    override fun showProgress() {
        binding.progressContainer.visibility = View.VISIBLE
    }

}