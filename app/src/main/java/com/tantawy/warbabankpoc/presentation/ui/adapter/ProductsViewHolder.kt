package com.tantawy.warbabankpoc.presentation.ui.adapter

import android.view.View
import com.tantawy.warbabankpoc.base.adapter.BaseViewHolder
import com.tantawy.domain.model.Products
import com.tantawy.warbabankpoc.databinding.ProductItemBinding


class ProductsViewHolder(itemView: View) : BaseViewHolder<Products>(itemView) {

    val binding = ProductItemBinding.bind(itemView)

    override fun onClick(v: View?) {
        super.onClick(v)
        v?.setOnClickListener {}
    }

    override fun fillData() {}
}