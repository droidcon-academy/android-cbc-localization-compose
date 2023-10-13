package com.droidcon.localizationcompose.ui.screens.home.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.droidcon.localizationcompose.R
import com.droidcon.localizationcompose.ui.toLocalizedString

@Composable
fun Total(total: Double, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.total, total.toLocalizedString()),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.displaySmall,
        modifier = modifier
    )
}