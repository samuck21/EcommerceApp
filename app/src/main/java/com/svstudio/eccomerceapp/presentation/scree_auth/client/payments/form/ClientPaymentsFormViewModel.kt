package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.MercadoPagoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsFormViewModel @Inject constructor(private val mercadoPagoUseCase: MercadoPagoUseCase): ViewModel() {

    var state by mutableStateOf(ClientPaymentsFormState())
        private set

    private fun ClientPaymentsFormState() {
        TODO("Not yet implemented")
    }

    var identificationTypesResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
        private set


    fun getIdentificationTypes() = viewModelScope.launch {
        identificationTypesResponse = Resource.Loading
        val result = mercadoPagoUseCase.getIdentificationType().first()
        identificationTypesResponse = result
        Log.d("ClientPaymentsFormViewModel", "Data: ${identificationTypesResponse}")
    }



}