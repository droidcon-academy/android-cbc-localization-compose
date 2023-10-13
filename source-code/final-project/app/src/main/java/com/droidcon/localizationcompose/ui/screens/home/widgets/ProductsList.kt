package com.droidcon.localizationcompose.ui.screens.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.droidcon.localizationcompose.R
import com.droidcon.localizationcompose.data.Product
import com.droidcon.localizationcompose.ui.toLocalizedString

@Composable
fun ProductsList(
    products: List<Product>,
    onProductRemoved: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(products) { product ->
            ProductItem(
                product = product,
                onProductRemoved = { onProductRemoved(product) }
            )
        }
    }
}

@Composable
fun ProductItem(product: Product, onProductRemoved: () -> Unit) {
    ListItem(
        headlineContent = {
            Text(text = product.name)
        },
        supportingContent = {
            Text(text = product.date.toLocalizedString())
        },
        trailingContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = product.price.toLocalizedString())
                IconButton(onClick = onProductRemoved) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(R.string.delete, product.name)
                    )
                }
            }
        }
    )
}