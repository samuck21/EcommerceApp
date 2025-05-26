package com.svstudio.eccomerceapp.domain.usecase.address

import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.repository.AddressRepository

class CreateAddressUseCase (private val repository: AddressRepository){
    suspend operator  fun invoke(address: Address) = repository.create(address)
}