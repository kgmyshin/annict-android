package com.kgmyshin.auth.infra.pref

import android.content.Context
import com.kgmyshin.common.pref.Preference

internal open class AccessTokenPreference(context: Context) : Preference(context) {

    companion object {
        private val KEY_ACCESS_TOKEN = "accessToken"
    }

    override fun prefName(): String = "AccessToken"

    open fun put(accessToken: String) {
        editor.putString(
                KEY_ACCESS_TOKEN,
                accessToken
        )
        editor.commit()
    }

    open fun get(): String? = sharedPreferences.getString(
            KEY_ACCESS_TOKEN,
            null
    )

}