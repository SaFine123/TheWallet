package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyItemState

@Composable
fun CurrencyList(
    modifier: Modifier = Modifier,
    currencyList: List<CurrencyItemState>
) {

    LazyColumn(
        modifier = modifier,
        content = {

            items(currencyList) { item ->

            CurrencyListItem(
                currencyName = item.currencyName,
                currencySymbol = item.currencySymbol,
                defaultCurrency = item.defaultCurrency
            )
        }
    })

}

@Preview(showBackground = true)
@Composable
fun CurrencyListPreview() {
    CurrencyList(
        currencyList = listOf(
            CurrencyItemState(
                currencyName = "Brazilian Real",
                currencySymbol = "R$",
                defaultCurrency = false
            ),
            CurrencyItemState(
                currencyName = "US Dollar",
                currencySymbol = "$",
                defaultCurrency = true
            ),
            CurrencyItemState(
                currencyName = "Euro",
                currencySymbol = "€",
                defaultCurrency = false
            )
        )
    )
}