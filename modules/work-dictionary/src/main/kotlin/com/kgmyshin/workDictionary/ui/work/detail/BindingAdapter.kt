package com.kgmyshin.workDictionary.ui.work.detail

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView

object BindingAdapter {

    @BindingAdapter("workDetail")
    @JvmStatic
    fun setWorkDetail(
            view: RecyclerView?,
            workDetail: WorkDetailViewModel?
    ) {
        if (view == null || workDetail == null) {
            return
        }
        val adapter = WorkDetailAdapter(
                view.context,
                workDetail
        )
        view.adapter = adapter
    }

}