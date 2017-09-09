package com.kgmyshin.common.di

import android.content.Context

object ContainerApplicationHelper {

    fun get(context: Context): ContainerApplication {
        val app = context.applicationContext
        if (app is ContainerApplication) {
            return app
        } else {
            throw ClassCastException("application must implement ContainerApplication")
        }
    }

}