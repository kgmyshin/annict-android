package com.kgmyshin.workDictionary.ui

import android.content.Context
import android.content.DialogInterface
import com.kgmyshin.common.errorHandler.ErrorHandler

internal class ErrorHandlerImpl : ErrorHandler {

    override fun showDialog(context: Context,
                            error: Throwable,
                            yesClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(context: Context,
                            msgResId: Int,
                            yesClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(context: Context,
                            error: Throwable,
                            retryClickListener: DialogInterface.OnClickListener?,
                            cancelClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showDialog(context: Context,
                            msgResId: Int,
                            retryClickListener: DialogInterface.OnClickListener?,
                            cancelClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showForceRetryDialog(context: Context,
                                      error: Throwable,
                                      retryClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showForceRetryDialog(context: Context,
                                      msgResId: Int,
                                      retryClickListener: DialogInterface.OnClickListener?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showToast(context: Context,
                           msgResId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}