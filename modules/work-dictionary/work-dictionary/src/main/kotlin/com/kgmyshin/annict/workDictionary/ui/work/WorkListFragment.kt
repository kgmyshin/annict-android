package com.kgmyshin.annict.workDictionary.ui.work

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.databinding.FragmentWorkListBinding

abstract class WorkListFragment : Fragment(), WorkListContract.View {

    private lateinit var binding: FragmentWorkListBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkListBinding.inflate(
                inflater,
                container,
                false
        )
        return binding.root
    }

    abstract fun onClickWork(workBindingModel: WorkBindingModel)

    override fun dismissProgress() {
        binding.progressContainer.visibility = View.GONE
    }

    override fun showProgress() {
        binding.progressContainer.visibility = View.VISIBLE
    }

    override fun setUp(bindingModelList: List<WorkBindingModel>) {
        binding.workBindingModelList = bindingModelList
        val adapter = binding.recyclerView.adapter as? WorkListAdapter
        adapter?.onClickListener = object : OnClickWorkListener {
            override fun onClick(workBindingModel: WorkBindingModel) {
                onClickWork(workBindingModel)
            }
        }
    }

}