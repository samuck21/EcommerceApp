package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.products.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ClientProductListViewModel @Inject constructor(private  val productsUseCase: ProductsUseCase): ViewModel(){
var productResponse by mutableStateOf<Resource<List<Product>>?>(null)
    private  set

    init {
        getProducts()
    }
    fun getProducts() = viewModelScope.launch {
        productResponse = Resource.Loading
        productsUseCase.findAll().collect {
            Log.d("ClientProductListView","Data:$it")
            productResponse=it
        }


    }

}