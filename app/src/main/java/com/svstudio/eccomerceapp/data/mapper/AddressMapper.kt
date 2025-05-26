package com.svstudio.eccomerceapp.data.mapper

import com.svstudio.eccomerceapp.data.dataSource.local.entity.AddressEntity
import com.svstudio.eccomerceapp.domain.model.Address

fun AddressEntity.toAddress(): Address{

    return Address(
       id= id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}
fun Address.toEntity(): AddressEntity{
    return AddressEntity(
        id = id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser =  idUser
    )
}