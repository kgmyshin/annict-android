package com.kgmyshin.annict.workDictionary.ui.work.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.databinding.ViewEpisodeItemBinding

class EpisodeViewHolder private constructor(
        private val binding: ViewEpisodeItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): EpisodeViewHolder = EpisodeViewHolder(ViewEpisodeItemBinding.inflate(
                inflater,
                parent,
                attachToRoot

        ))
    }

    fun bind(episodeViewModel: EpisodeViewModel) {
        binding.episodeViewModel = episodeViewModel
        binding.executePendingBindings()
    }

}