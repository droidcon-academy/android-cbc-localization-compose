package com.droidcon.localizationcompose.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidcon.localizationcompose.R
import com.droidcon.localizationcompose.data.Product
import com.droidcon.localizationcompose.ui.screens.home.widgets.AddProduct
import com.droidcon.localizationcompose.ui.screens.home.widgets.ProductsList
import com.droidcon.localizationcompose.ui.screens.home.widgets.Total

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    Home(
        state = viewModel.state,
        onProductAdded = viewModel::onProductAdded,
        onProductRemoved = viewModel::onProductRemoved,
        onDismissError = viewModel::onDismissError
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    state: HomeViewModel.UiState,
    onProductAdded: (name: String, price: String) -> Unit,
    onProductRemoved: (Product) -> Unit,
    onDismissError: () -> Unit
) {

    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarMessage = stringResource(R.string.invalid_price)

    LaunchedEffect(state.isError) {
        if (state.isError) {
            snackbarHostState.showSnackbar(message = snackbarMessage)
            onDismissError()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = pluralStringResource(
                        id = R.plurals.product_quantity,
                        state.products.size,
                        state.products.size
                    )
                )
            })
        },
        snackbarHost = { SnackbarHost(snackbarHostState) { Snackbar(it) } }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AddProduct(onProductAdded = onProductAdded)
            ProductsList(
                products = state.products,
                onProductRemoved = onProductRemoved,
                modifier = Modifier.weight(1f)
            )
            Total(
                total = state.total,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}