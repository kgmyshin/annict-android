package com.kgmyshin.workDictionary.ui.work

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kgmyshin.workDictionary.databinding.ViewWorkBinding

class WorkListViewHolder private constructor(private val binding: ViewWorkBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
                inflater: LayoutInflater,
                parent: ViewGroup?,
                attachToRoot: Boolean
        ) = WorkListViewHolder(ViewWorkBinding.inflate(
                inflater,
                parent,
                attachToRoot
        ))
    }

    fun bind(viewModel: WorkViewModel) {
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}