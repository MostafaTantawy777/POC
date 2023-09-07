package com.tantawy.warbabankpoc.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tantawy.warbabankpoc.R
import com.tantawy.warbabankpoc.base.adapter.BaseAdapter
import com.tantawy.warbabankpoc.base.adapter.BaseViewHolder
import com.tantawy.domain.model.Products

class ProductsAdapter(private val items: ArrayList<Products>? = null, itemLayoutRes: Int? = null) :
    BaseAdapter<Products>(items, itemLayoutRes) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Products> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Products>, position: Int) {
        super.onBindViewHolder(holder, position)
        val productsViewHolder = holder as ProductsViewHolder
        productsViewHolder.binding.productName.text = items?.get(position)?.title
        Glide.with(holder.itemView.context).load(items?.get(position)?.image)
            .apply(RequestOptions.errorOf(R.drawable.ic_error))
            .into(productsViewHolder.binding.productImage)
    }
}