package com.kgmyshin.common.errorHandler

import android.content.Context
import android.content.DialogInterface
import android.support.annotation.StringRes

interface ErrorHandler {

    fun showDialog(
            context: Context,
            error: Throwable,
            yesClickListener: DialogInterface.OnClickListener?
    )

    fun showDialog(
            context: Context,
            @StringRes msgResId: Int,
            yesClickListener: DialogInterface.OnClickListener?
    )

    fun showDialog(
            context: Context,
            error: Throwable,
            retryClickListener: DialogInterface.OnClickListener?,
            cancelClickListener: DialogInterface.OnClickListener?
    )

    fun showDialog(
            context: Context,
            @StringRes msgResId: Int,
            retryClickListener: DialogInterface.OnClickListener?,
            cancelClickListener: DialogInterface.OnClickListener?
    )

    fun showForceRetryDialog(
            context: Context,
            error: Throwable,
            retryClickListener: DialogInterface.OnClickListener?
    )

    fun showForceRetryDialog(
            context: Context,
            @StringRes msgResId: Int,
            retryClickListener: DialogInterface.OnClickListener?
    )

    fun showToast(
            context: Context,
            @StringRes msgResId: Int
    )

}