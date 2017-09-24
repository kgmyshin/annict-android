package com.kgmyshin.auth.infra.pref

import android.content.Context
import com.kgmyshin.common.pref.Preference

internal class AccessTokenPreference(context: Context) : Preference(context) {

    companion object {
        private val KEY_ACCESS_TOKEN = "accessToken"
    }

    override fun prefName(): String = "AccessToken"

    fun put(accessToken: String) {
        editor.putString(
                KEY_ACCESS_TOKEN,
                accessToken
        )
        editor.commit()
    }

    fun get(): String? = sharedPreferences.getString(
            KEY_ACCESS_TOKEN,
            null
    )

}