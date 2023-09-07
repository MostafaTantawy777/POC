package com.tantawy.warbabankpoc.presentation.ui.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.tantawy.warbabankpoc.R
import com.tantawy.warbabankpoc.base.fragment.BaseFragment
import com.tantawy.warbabankpoc.common.CommonState
import com.tantawy.domain.model.Products
import com.tantawy.warbabankpoc.databinding.FragmentProductsBinding
import com.tantawy.warbabankpoc.presentation.ui.adapter.ProductsAdapter
import com.tantawy.warbabankpoc.presentation.viewmodels.ProductsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsFragment : BaseFragment() {

    private var binding: FragmentProductsBinding? = null
    private lateinit var productsAdapter: ProductsAdapter
    private val productsViewModel: ProductsViewModel by viewModel()
    private var products: ArrayList<Products> = arrayListOf()

    override fun layoutResource(): Int = R.layout.fragment_products

    override fun onViewInflated(parentView: View, inflateView: View) {
        super.onViewInflated(parentView, inflateView)
        binding = FragmentProductsBinding.bind(inflateView)
        initViews()
        productsViewModel.fetchProducts()
    }

    private fun initViews() {
        productsAdapter = ProductsAdapter(products, R.layout.product_item)
        binding?.productsRV?.adapter = productsAdapter
    }

    override fun initObservers() {
        lifecycleScope.launch {
            productsViewModel.apply {
                repeatOnLifecycle(Lifecycle.State.STARTED) {

                    launch {
                        productsState.collect { it ->
                            when (it) {
                                CommonState.LoadingShow -> showProgressDialog()
                                CommonState.LoadingFinished -> hideProgressDialog()
                                is CommonState.Success -> {
                                    products = it.data
                                    products?.let { it1 -> productsAdapter?.addItems(it1) }
                                }

                                is CommonState.Error -> Log.e("repos repo", "error")

                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}