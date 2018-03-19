package com.kgmyshin.annict.workDictionary.ui.work

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.databinding.ViewWorkItemBinding

class WorkItemViewHolder private constructor(
        private val binding: ViewWorkItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ): WorkItemViewHolder = WorkItemViewHolder(ViewWorkItemBinding.inflate(
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