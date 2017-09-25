package com.kgmyshin.common.pref

import android.content.Context
import android.content.SharedPreferences

abstract class Preference(private val context: Context) {

    protected abstract fun prefName(): String

    protected val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(
                prefName(),
                Context.MODE_PRIVATE
        )

    protected val editor: SharedPreferences.Editor
        get() {
            val prefs = sharedPreferences
            return prefs.edit()
        }

}