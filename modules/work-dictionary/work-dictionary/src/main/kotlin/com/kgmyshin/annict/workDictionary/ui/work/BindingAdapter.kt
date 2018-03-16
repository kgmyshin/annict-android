package com.kgmyshin.annict.workDictionary.ui.work

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.squareup.picasso.Picasso

internal object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadUrl(
            view: ImageView?,
            imageUrl: String?
    ) {
        if (view == null) {
            return
        }
        if (imageUrl == null || imageUrl.isEmpty()) {
            view.setImageDrawable(null)
            return
        }
        Picasso.with(view.context)
                .load(imageUrl)
                .into(view)
    }

    @BindingAdapter("workList")
    @JvmStatic
    fun setItemList(
            view: RecyclerView?,
            workList: List<WorkViewModel>?
    ) {
        if (view == null || workList == null) {
            return
        }
        val adapter = WorkListAdapter(
                view.context,
                workList
        )
        view.adapter = adapter
    }

}