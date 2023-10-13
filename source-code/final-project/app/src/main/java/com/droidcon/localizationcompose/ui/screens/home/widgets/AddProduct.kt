package com.droidcon.localizationcompose.ui.screens.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.droidcon.localizationcompose.R

@Composable
fun AddProduct(onProductAdded: (name: String, price: String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var name by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        val buttonEnabled = name.isNotBlank() && price.isNotBlank()

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = stringResource(R.string.product)) },
            modifier = Modifier.weight(1f),
        )
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text(text = stringResource(R.string.price)) },
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = { onProductAdded(name, price) },
            enabled = buttonEnabled
        ) {
            Text(text = stringResource(id = R.string.add))
        }
    }
}