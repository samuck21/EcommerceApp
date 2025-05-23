package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.listByCategory

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.products.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductByCategoryListViewModel @Inject constructor(
    private  val productsUseCase: ProductsUseCase,
    private val savedStateHandle: SavedStateHandle,
    ): ViewModel() {
        var data  = savedStateHandle.get<String>("category")
        var category = Category.fromJson(data!!)
    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set
    var productsDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getProducts()

    }
    fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productsUseCase.findByCategory(category.id!!).collect {
            productsResponse = it
            Log.d("AdminProductListViewModel", "Data:${productsResponse}")
        }

    }


}