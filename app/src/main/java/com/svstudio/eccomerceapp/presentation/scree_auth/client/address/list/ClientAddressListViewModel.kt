package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.repository.AddressRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.address.AddressUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressListViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private  val authUseCase: AuthUseCase
):
    ViewModel (){
        var addressResponse by mutableStateOf<Resource<List<Address>>?>(null)
            private set
    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionData().first().user
        getAddress(user?.id?: "")
    }
    fun getAddress(idUser: String) = viewModelScope.launch {
        addressResponse = Resource.Loading
        addressUseCase.findByUserAddress(idUser).collect {
            Log.d("ClientAddressListViewModel","Data:${it}")
            addressResponse = it
        }
    }




}