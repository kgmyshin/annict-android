package com.kgmyshin.annict.auth.ui

import android.content.Context
import android.content.DialogInterface
import com.kgmyshin.common.errorHandler.ErrorHandler

internal class ErrorHandlerImpl : ErrorHandler {

    override fun showDialog(context: Context,
                            error: Throwable,
                            yesClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showDialog(context: Context,
                            msgResId: Int,
                            yesClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showDialog(context: Context,
                            error: Throwable,
                            retryClickListener: DialogInterface.OnClickListener?,
                            cancelClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showDialog(context: Context,
                            msgResId: Int,
                            retryClickListener: DialogInterface.OnClickListener?,
                            cancelClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showForceRetryDialog(context: Context,
                                      error: Throwable,
                                      retryClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showForceRetryDialog(context: Context,
                                      msgResId: Int,
                                      retryClickListener: DialogInterface.OnClickListener?) {
        // TODO: must impl
    }

    override fun showToast(context: Context,
                           msgResId: Int) {
        // TODO: must impl
    }
}