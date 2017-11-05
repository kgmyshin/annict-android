package com.kgmyshin.workDictionary.ui.work

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class WorkListAdapter(
        context: Context,
        private val workViewModelList: List<WorkViewModel>
) : RecyclerView.Adapter<WorkItemViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    var onClickListener: OnClickWorkListener? = null

    override fun onBindViewHolder(
            holder: WorkItemViewHolder?,
            position: Int
    ) {
        holder?.bind(workViewModelList[position])
        holder?.itemView?.setOnClickListener {
            onClickListener?.onClick(workViewModelList[position])
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup?,
            viewType: Int
    ): WorkItemViewHolder = WorkItemViewHolder.create(
            inflater,
            parent,
            false
    )

    override fun getItemCount(): Int = workViewModelList.size

}