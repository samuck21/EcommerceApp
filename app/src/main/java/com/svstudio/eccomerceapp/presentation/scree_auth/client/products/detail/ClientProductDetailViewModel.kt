package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ShoppingBagProductEntity
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel(){
    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImage = listOf<String>(product.image1 ?:"",product.image2 ?:"")
    var quantity by mutableStateOf(0)
        private  set
    var price by mutableStateOf(0.0)
        private  set
    init {
        getShoppingBag()
    }
    fun add(){
        quantity = quantity +1
    }
    fun remove(){
       if(quantity > 0){
           quantity = quantity-1
       }

    }
    fun getShoppingBagProduct() = viewModelScope.launch {
        val result = shoppingBagUseCase.findById(product.id ?:"")
        quantity = result?.quantity ?:0  //?
        price = product.price * quantity
    }
    fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAll().collect {
            Log.d("ClientProductDetailViewModel","Data:${it}")
        }
    }
    fun saveItem() = viewModelScope.launch {
        if(quantity > 0){
            val shoppingBagProduct = ShoppingBagProduct(
                id = product.id ?:"",
                name = product.name,
                price = product.price,
                image1 = product.image1 ?:"",
                idCategory = product.idCategory,
                quantity = quantity
            )
            shoppingBagUseCase.add(shoppingBagProduct)
        }
    }
}