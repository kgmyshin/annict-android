package com.kgmyshin.annict.auth.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kgmyshin.annict.auth.ui.R

class LoginActivity : AppCompatActivity(), ScreenTransition {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportFragmentManager.beginTransaction().apply {
            replace(
                    R.id.container,
                    LoginFragment.newInstance()
            )
        }.commitNow()
    }

    override fun moveToHome() {
        Intent().apply {
            setClassName(
                    applicationContext.packageName,
                    "com.kgmyshin.workDictionary.ui.work.search.SearchWorkListActivity"
            )
        }.let { startActivity(it) }
    }
}