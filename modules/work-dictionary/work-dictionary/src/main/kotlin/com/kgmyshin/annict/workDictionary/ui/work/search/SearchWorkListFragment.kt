package com.kgmyshin.annict.workDictionary.ui.work.search

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.WorkDictionaryComponent
import com.kgmyshin.annict.workDictionary.databinding.FragmentWorkListBinding
import com.kgmyshin.annict.workDictionary.ui.work.OnClickWorkListener
import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListAdapter
import com.kgmyshin.annict.workDictionary.ui.work.WorkViewModel
import com.kgmyshin.common.di.ContainerApplicationHelper
import javax.inject.Inject

class SearchWorkListFragment : Fragment(), SearchWorkListContract.View {


    companion object {

        fun newInstance() = SearchWorkListFragment()
    }

    @Inject
    internal lateinit var presenter: SearchWorkListContract.Presenter

    private lateinit var binding: FragmentWorkListBinding

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ContainerApplicationHelper.get(activity).getComponent(WorkDictionaryComponent::class).inject(this)
        val screenTransition = (context as? ScreenTransition)
                ?: throw ClassCastException("must cast ScreenTransition")
        presenter.setUp(
                this,
                screenTransition
        )
        presenter.onAttach()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkListBinding.inflate(
                inflater,
                container,
                false
        )
        return binding.root
    }

    override fun dismissProgress() {
        binding.progressContainer.visibility = View.GONE
    }

    override fun showProgress() {
        binding.progressContainer.visibility = View.VISIBLE
    }

    override fun setUp(viewModelList: List<WorkViewModel>) {
        binding.workViewModelList = viewModelList
        val adapter = binding.recyclerView.adapter as? WorkListAdapter
        adapter?.onClickListener = object : OnClickWorkListener {
            override fun onClick(workViewModel: WorkViewModel) {
                presenter.onClickWork(workViewModel)
            }
        }
    }

    fun onUpdateKeyword(keyword: String) {
        presenter.onUpdateKeyword(keyword)
    }

}