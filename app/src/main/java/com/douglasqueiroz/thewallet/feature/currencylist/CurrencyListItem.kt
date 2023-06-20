package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyListItem(
    currencyName: String,
    currencySymbol: String,
    defaultCurrency: Boolean,
    modifier: Modifier = Modifier,
    onClick: ()-> Unit
) {

    Row(
        modifier = modifier
            .padding(16.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$currencyName ($currencySymbol)",
            modifier = Modifier.weight(1f)
        )

        if (defaultCurrency) {
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                tint = Color.Green,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyListItemPreview() {
    CurrencyListItem(
        currencyName = "US Dollar",
        currencySymbol = "$",
        defaultCurrency = true,
        onClick = {}
    )
}