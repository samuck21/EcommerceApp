package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.componets

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.domain.model.PayerCost
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.ClientPaymentsInstallmentsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientPaymentsInstallmentsContent(
    paddingValues: PaddingValues,
    installments: List<PayerCost>,
    vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()
) {
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(20.dp)) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                value = vm.selectedInstallment?.recommendedMessage ?: "",
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
                installments.forEachIndexed { _, installment ->
                    DropdownMenuItem(
                        text = { Text(text = installment.recommendedMessage) },
                        onClick = {
                            vm.selectedInstallment = installment
                            expanded = false
                        }
                    )
                }
            }
        }

    }
}