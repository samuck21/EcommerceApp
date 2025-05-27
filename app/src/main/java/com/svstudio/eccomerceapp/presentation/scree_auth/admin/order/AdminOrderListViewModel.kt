package com.svstudio.eccomerceapp.presentation.scree_auth.admin.order

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Order
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.orders.OrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderListViewModel @Inject constructor(private val ordersUseCase: OrdersUseCase): ViewModel() {

    var ordersResponse by mutableStateOf<Resource<List<Order>>?>(null)
//    var ordersByClientResponse by mutableStateOf<Resource<List<Order>>?>(null)
//    var ordersStatusResponse by mutableStateOf<Resource<Order>?>(null)

    fun getOrders() = viewModelScope.launch {
        ordersResponse = Resource.Loading
        ordersUseCase.findAllOrders().collect() {
            ordersResponse = it
            Log.d("AdminOrderListViewModel", "Data Orders: ${ordersResponse}")
        }
    }

//    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
//        ordersByClientResponse = Resource.Loading
//        ordersUseCase.findByClientOrders(idClient).collect() {
//            ordersByClientResponse = it
//            Log.d("AdminOrderListViewModel", "Data Orders By Client: ${ordersByClientResponse}")
//        }
//    }
//


}