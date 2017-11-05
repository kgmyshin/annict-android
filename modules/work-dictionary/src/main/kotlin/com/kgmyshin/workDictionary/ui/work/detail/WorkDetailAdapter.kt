package com.kgmyshin.workDictionary.ui.work.detail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class WorkDetailAdapter(
        context: Context,
        private val workViewDetailViewModel: WorkDetailViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_WORK = 1
        private const val VIEW_TYPE_EPISODE = 2
    }

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount(): Int = (1 + workViewDetailViewModel.episodeViewModelList.size)

    override fun onBindViewHolder(
            holder: RecyclerView.ViewHolder?,
            position: Int
    ) {
        if (holder is WorkViewHolder) {
            holder.bind(workViewDetailViewModel.workViewModel)
        } else if (holder is EpisodeViewHolder) {
            holder.bind(workViewDetailViewModel.episodeViewModelList[position - 1])
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup?,
            viewType: Int
    ): RecyclerView.ViewHolder = when (viewType) {
        VIEW_TYPE_WORK ->
            WorkViewHolder.create(
                    inflater,
                    parent,
                    false
            )
        VIEW_TYPE_EPISODE ->
            EpisodeViewHolder.create(
                    inflater,
                    parent,
                    false
            )
        else -> throw IllegalArgumentException("illegal viewType = $viewType")
    }

    override fun getItemViewType(position: Int): Int = if (position == 0) {
        VIEW_TYPE_WORK
    } else {
        VIEW_TYPE_EPISODE
    }
}