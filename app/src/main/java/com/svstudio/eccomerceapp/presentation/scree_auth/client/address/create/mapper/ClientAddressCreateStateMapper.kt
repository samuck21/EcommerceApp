package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.mapper

import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address{
    return Address(
        address =  address,
        neighborhood = neigborhood,
        idUser =  idUser
    )
}