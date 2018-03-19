package com.kgmyshin.annict.workDictionary.ui.work.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.databinding.ViewWorkBinding
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel

class WorkViewHolder private constructor(
        private val binding: ViewWorkBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {

        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): WorkViewHolder = WorkViewHolder(ViewWorkBinding.inflate(
                inflater,
                parent,
                attachToRoot
        ))
    }

    fun bind(workViewModel: WorkViewModel) {
        binding.workViewModel = workViewModel
        binding.executePendingBindings()
    }

}