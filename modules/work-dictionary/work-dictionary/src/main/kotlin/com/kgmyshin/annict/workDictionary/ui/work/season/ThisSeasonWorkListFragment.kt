package com.kgmyshin.annict.workDictionary.ui.work.season

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kgmyshin.annict.workDictionary.WorkDictionaryComponent
import com.kgmyshin.annict.workDictionary.ui.work.ScreenTransition
import com.kgmyshin.annict.workDictionary.ui.work.WorkListContract
import com.kgmyshin.annict.workDictionary.ui.work.WorkListFragment
import com.kgmyshin.annict.workDictionary.ui.work.WorkBindingModel
import com.kgmyshin.common.di.ContainerApplicationHelper
import javax.inject.Inject

class ThisSeasonWorkListFragment : WorkListFragment(), WorkListContract.View {

    companion object {
        fun newInstance() = ThisSeasonWorkListFragment()
    }

    @Inject
    internal lateinit var presenter: ThisSeasonWorkListContract.Presenter

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

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        presenter.onCreateView()
        return super.onCreateView(
                inflater,
                container,
                savedInstanceState
        )
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    override fun onClickWork(workBindingModel: WorkBindingModel) {
        presenter.onClickWork(workBindingModel)
    }


}