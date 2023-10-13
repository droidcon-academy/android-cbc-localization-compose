package com.droidcon.localizationcompose.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.droidcon.localizationcompose.data.Product
import com.droidcon.localizationcompose.ui.toLocalizedDouble
import java.util.Date

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val products: List<Product> = emptyList(),
        val total: Double = 0.0,
        val isError: Boolean = false
    )

    fun onProductAdded(name: String, price: String) {
        price.toLocalizedDouble()?.let {
            onProductAdded(name, it)
        } ?: run {
            state = state.copy(isError = true)
        }
    }

    private fun onProductAdded(name: String, price: Double) {
        state = state.copy(
            products = state.products + Product(name, price, Date()),
            total = state.total + price
        )
    }

    fun onProductRemoved(product: Product) {
        state = state.copy(
            products = state.products - product,
            total = state.total - product.price
        )
    }

    fun onDismissError() {
        state = state.copy(isError = false)
    }

}