package com.svstudio.eccomerceapp.domain.usecase.address

import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.repository.AddressRepository

class FindByUserAddressUseCase (private val repository: AddressRepository){
    suspend operator  fun invoke(idUser: String) = repository.findByUserAddress(idUser)
}