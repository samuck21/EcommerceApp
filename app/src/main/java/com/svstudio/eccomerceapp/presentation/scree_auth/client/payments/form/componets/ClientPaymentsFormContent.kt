package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.componets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable

fun ClientPaymentsFormContent(paddingValues: PaddingValues){
    Text(
        modifier = Modifier.padding(paddingValues),
        text = "ClientPaymentsFormScreen"
    )
}