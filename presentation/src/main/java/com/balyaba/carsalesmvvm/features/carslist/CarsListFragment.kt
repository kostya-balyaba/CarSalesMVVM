package com.balyaba.carsalesmvvm.features.carslist

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_cars_list.*
import javax.inject.Inject


class CarsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: CarsListViewModel

    private val adapter: CarsListAdapter by lazy { CarsListAdapter() }
    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = injectViewModel(factory = viewModelFactory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cars_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        subscribeViewState()
        viewModel.obtainEvent(CarsListViewEvent.LoadCarsList)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    private fun initUI() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun subscribeViewState() {
        compositeDisposable.add(
            viewModel.viewState.subscribe({
                bindViewState(it)
            }, {
                Log.d("asd", "onError = " + it)
            }))
    }

    private fun bindViewState(viewState: CarsListViewState) {
        when (viewState) {
            CarsListViewState.Loading -> {
                showLoadingView()
            }
            is CarsListViewState.Success -> {
                adapter.addItems(viewState.data)
                showCarsListView()
            }
            is CarsListViewState.ShowError -> {
                errorTextView.text = viewState.message
                showErrorView()
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