package com.balyaba.carsalesmvvm.features.carslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.balyaba.carsalesmvvm.R
import com.balyaba.carsalesmvvm.common.ui.hide
import com.balyaba.carsalesmvvm.common.ui.show
import com.balyaba.carsalesmvvm.common.vm.injectViewModel
import com.balyaba.carsalesmvvm.features.carslist.adapter.CarsListAdapter
import com.balyaba.carsalesmvvm.features.carslist.models.CarsListViewEffect
import com.balyaba.carsalesmvvm.features.carslist.models.CarsListViewState
import com.balyaba.carsalesmvvm.features.carslist.models.OnStartCarDetailsScreen
import com.balyaba.carsalesmvvm.features.carslist.models.Status
import com.balyaba.carsalesmvvm.features.main.MainActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_cars_list.*
import javax.inject.Inject


class CarsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: CarsListViewModel

    private val adapter: CarsListAdapter by lazy { CarsListAdapter(requireContext()) }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(factory = viewModelFactory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cars_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        setupObserver()
        viewModel.loadCarsList()
    }

    private fun initUI() {
        if (!adapter.hasObservers())
            adapter.setHasStableIds(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        adapter.listener = viewModel.adapterListener
    }

    private fun setupObserver() {
        viewModel.viewState().observe(viewLifecycleOwner, {
            processViewState(it)
        })
        viewModel.viewEffects().observe(viewLifecycleOwner, {
            processViewEffect(it)
        })
    }

    private fun processViewState(state: CarsListViewState) {
        when (state.status) {
            is Status.Loading -> showLoadingView()
            is Status.Success -> {
                adapter.replaceItems(state.data)
                showCarsListView()
            }
            is Status.Empty -> {
                errorTextView.text = getString(R.string.empty_screen)
                showErrorView()
            }
            is Status.Error -> {
                errorTextView.text = state.errorMessage
                showErrorView()
            }
        }
    }

    private fun processViewEffect(viewEffect: CarsListViewEffect) {
        when (viewEffect) {
            is OnStartCarDetailsScreen -> {
                val action = CarsListFragmentDirections.actionCarsListFragmentToCarDetailsFragment(viewEffect.carId)
                (activity as MainActivity).navController.navigate(action)
            }
        }
    }

    private fun showLoadingView() {
        errorTextView.hide()
        recyclerView.hide()
        progressBar.show()
    }

    private fun showErrorView() {
        recyclerView.hide()
        progressBar.hide()
        errorTextView.show()
    }

    private fun showCarsListView() {
        progressBar.hide()
        errorTextView.hide()
        recyclerView.show()
    }
}