package com.svstudio.eccomerceapp.domain.usecase.address

data class AddressUseCase (
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase,
)