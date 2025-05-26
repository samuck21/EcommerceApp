package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.until.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    suspend fun create(address: Address): Resource<Address>
    fun findByUserAddress(idUser: String): Flow<Resource<List<Address>>>

}