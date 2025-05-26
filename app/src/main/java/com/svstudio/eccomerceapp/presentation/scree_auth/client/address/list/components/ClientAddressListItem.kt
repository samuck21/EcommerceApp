package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.ClientAddressListViewModel

@Composable

fun ClientAddressListItem(address: Address, vm: ClientAddressListViewModel = hiltViewModel()){
    Column (
        modifier = Modifier.padding( horizontal =  20.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = address.id == vm.selectedAddress,
                onClick = {
                       vm.onSelectedAddressInput(address)
                }
            )
        }
        Column {
            Text(
                text = address.address,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Spacer( modifier = Modifier.height(3.dp))
            Text(
                text = address.neighborhood,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.Gray
        )
    }
}