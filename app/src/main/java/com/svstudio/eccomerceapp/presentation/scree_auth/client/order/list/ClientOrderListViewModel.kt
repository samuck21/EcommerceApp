package com.svstudio.eccomerceapp.presentation.scree_auth.client.order.list

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Order
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.domain.usecase.orders.OrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientOrderListViewModel @Inject constructor(
    private val ordersUseCase: OrdersUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set
    var ordersResponse by mutableStateOf<Resource<List<Order>>?>(null)
        private set

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
        getOrdersByClient(user?.id ?: "")
    }

    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
        ordersResponse = Resource.Loading
        ordersUseCase.findByClientOrders(idClient).collect() {
            ordersResponse = it
        }
    }

}