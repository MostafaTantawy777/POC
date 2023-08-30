package com.tantawy.warbabankpoc.presentation.ui.fragment

import android.view.View
import com.tantawy.warbabankpoc.R
import com.tantawy.warbabankpoc.base.fragment.BaseFragment
import com.tantawy.warbabankpoc.databinding.FragmentProductsBinding

class CartFragment : BaseFragment() {

    private var binding: FragmentProductsBinding? = null

    override fun layoutResource(): Int = R.layout.fragment_products

    override fun onViewInflated(parentView: View, inflateView: View) {
        super.onViewInflated(parentView, inflateView)
        binding = FragmentProductsBinding.bind(inflateView)
    }
}