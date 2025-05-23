package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.svstudio.eccomerceapp.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImage = listOf<String>(product.image1 ?:"",product.image2 ?:"")
}