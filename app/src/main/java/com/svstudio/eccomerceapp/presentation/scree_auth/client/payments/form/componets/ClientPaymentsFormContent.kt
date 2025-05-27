package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.componets.DefaultTextField
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.ClientPaymentsFormViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.mapper.toCardTokenBody

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ClientPaymentsFormContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    identificationTypes: List<String>,
    vm: ClientPaymentsFormViewModel = hiltViewModel()
) {
    val state = vm.state
    var selectedItem by remember { mutableStateOf(identificationTypes[0]) }
    vm.onIdentificationTypeInput(selectedItem)
    var expanded by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { vm.onCardNumberInput(it) },
            label = "Numero de la tarjeta",
            icon = Icons.Default.Settings,
            keyboardType = KeyboardType.Number
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationYear,
                onValueChange = { vm.onYearExpirationInput(it) },
                label = "Año de expiracion YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,

            )

            Spacer(modifier = Modifier.width(5.dp))

            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationMonth,
                onValueChange = { vm.onMonthExpirationInput(it) },
                label = "Mes de expiracion MM",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nombre del titular",
            icon = Icons.Default.Person
        )

        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Codigo de seguridad",
            icon = Icons.Default.Lock
        )

        Spacer(modifier = Modifier.height(10.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Tipo de identificación") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                identificationTypes.forEach { identification ->
                    androidx.compose.material3.DropdownMenuItem(
                        onClick ={
                            selectedItem = identification
                            vm.onIdentificationTypeInput(selectedItem)
                            expanded= false
                        } ,
                        text = { Text(identification) },
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Número de identificación",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate(
                    route = ShoppingBagScreen.PaymentsInstallments.passPaymentForm(
                        state.toCardTokenBody().toJson())
                ){
                    popUpTo(ShoppingBagScreen.PaymentsForm.route){
                        inclusive= true
                  }
               }
            }
        ) {
            Text("Continuar")
        }


    }
}

