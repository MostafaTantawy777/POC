package com.tantawy.warbabankpoc.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.tantawy.warbabankpoc.base.CustomProgressDialog
import com.tantawy.warbabankpoc.databinding.FragmentBaseBinding
import com.tantawy.warbabankpoc.utils.extentions.getDrawableCompat
import com.tantawy.warbabankpoc.utils.extentions.hide
import com.tantawy.warbabankpoc.utils.extentions.show

abstract class BaseFragment : Fragment() {

    @LayoutRes
    abstract fun layoutResource(): Int
    private lateinit var binding: FragmentBaseBinding
    private lateinit var progressDialog: CustomProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaseBinding.inflate(inflater, container, false)
        binding.apply {
            stub.apply {
                layoutResource = layoutResource()
                setOnInflateListener { parentView, inflateId ->
                    onViewInflated(
                        parentView,
                        inflateId
                    )
                }
            }
        }
        return binding.root
    }

    override fun onViewCreated(parentView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(parentView, savedInstanceState)
        progressDialog = CustomProgressDialog(requireActivity())
        binding.stub.inflate()
        initEventHandler()
    }

    open fun onViewInflated(parentView: View, inflateView: View) {
        initObservers()
    }

    open fun initObservers() {}

    open fun initEventHandler() {}

    protected fun hideProgress() {
        binding.loadingViewInc.loadingView.hide()
    }

    fun hideError() {
        binding.placeHolderLayoutInc.placeHolderLayout.hide()
    }

    protected fun showProgress() {
        binding.loadingViewInc.loadingView.show()
        hideError()
    }

    protected fun showError(error: String) {
        binding.placeHolderLayoutInc.placeHolderLayout.visibility = View.VISIBLE
        binding.placeHolderLayoutInc.tvPlaceHolderMessage.text = error
    }


    fun showProgressDialog() {
        progressDialog.show()
    }

    fun hideProgressDialog() {
        progressDialog.dismiss()
    }

    fun setPlaceHolderResource(@DrawableRes placeHolderResource: Int) {
        binding.placeHolderLayoutInc.imgViewPlaceHolder.visibility = View.VISIBLE
        binding.placeHolderLayoutInc.imgViewPlaceHolder.setImageDrawable(
            requireContext().getDrawableCompat(
                placeHolderResource
            )
        )
    }
}