package com.kgmyshin.common.di

import android.content.Context
import android.support.v4.app.FragmentActivity

object ContainerApplicationHelper {

    fun get(context: FragmentActivity?): ContainerApplication {
        val app = context?.applicationContext
        if (app is ContainerApplication) {
            return app
        } else {
            throw ClassCastException("application must implement ContainerApplication")
        }
    }

    fun get(context: Context): ContainerApplication {
        val app = context.applicationContext
        if (app is ContainerApplication) {
            return app
        } else {
            throw ClassCastException("application must implement ContainerApplication")
        }
    }

}