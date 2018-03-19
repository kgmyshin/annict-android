package com.kgmyshin.annict.workDictionary.ui.work.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.databinding.FragmentWorkDetailBinding
import javax.inject.Inject

class WorkDetailFragment : Fragment(), WorkDetailContract.View {

    companion object {

        private const val KEY_WORK_ID = "workId"

        fun newInstance(workId: String): WorkDetailFragment = WorkDetailFragment().apply {
            val args = Bundle()
            args.putString(
                    KEY_WORK_ID,
                    workId
            )
            arguments = args
        }
    }

    @Inject
    internal lateinit var presenter: WorkDetailContract.Presenter

    private lateinit var binding: FragmentWorkDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkDetailBinding.inflate(
                inflater,
                container,
                false
        )
        return binding.root
    }

    override fun showProgress() {
        binding.progressContainer.visibility = View.VISIBLE
    }

    override fun dismissProgress() {
        binding.progressContainer.visibility = View.GONE
    }

    override fun setUp(workDetailViewModel: WorkDetailViewModel) {
        binding.workDetailViewModel = workDetailViewModel
    }
}