package com.tantawy.warbabankpoc.presentation.viewmodels

import androidx.lifecycle.*
import com.tantawy.warbabankpoc.common.CommonState
import com.tantawy.domain.model.Products
import com.tantawy.domain.usecases.GetProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsUseCase: GetProductsUseCase) : ViewModel() {

    private val _productsState =
        MutableStateFlow<CommonState<ArrayList<Products>>>(CommonState.UnInit)
    val productsState: StateFlow<CommonState<ArrayList<Products>>> = _productsState

    fun fetchProducts() {
        viewModelScope.launch(context = Dispatchers.Main) {
            _productsState.value = CommonState.LoadingShow
            productsUseCase.execute()
                .catch {
                    _productsState.value = CommonState.Error(it)
                    it.printStackTrace()
                }
                .onCompletion { _productsState.value = CommonState.LoadingFinished }
                .collect {
                    _productsState.value = CommonState.Success(it)
                }
        }
    }
}