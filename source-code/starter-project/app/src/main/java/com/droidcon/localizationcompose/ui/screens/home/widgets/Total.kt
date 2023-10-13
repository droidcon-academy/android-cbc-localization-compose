package com.droidcon.localizationcompose.ui.screens.home.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Total(total: Double, modifier: Modifier = Modifier) {
    Text(
        text = "Total: $total",
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier
    )
}