package com.svstudio.eccomerceapp.presentation.scree_auth.client.order.detail

import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.svstudio.eccomerceapp.domain.model.Order
import com.svstudio.eccomerceapp.domain.usecase.orders.OrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientOrderDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val ordersUseCase: OrdersUseCase
): ViewModel() {

    var data = savedStateHandle.get<String>("order")
    var order = Order.fromJson(data!!)

    var totalToPay by mutableStateOf(0.0)
        private set

    init {
        getTotal()
    }

    fun getTotal() {
        order.orderHasProducts?.forEach { ohp ->
            totalToPay = totalToPay + (ohp.quantity * ohp.product.price)
        }
    }

}