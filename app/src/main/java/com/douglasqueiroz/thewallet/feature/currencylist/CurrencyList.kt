package com.douglasqueiroz.thewallet.feature.currencylist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyListEvent
import com.douglasqueiroz.thewallet.feature.currencylist.state.CurrencyItemState

@Composable
fun CurrencyList(
    modifier: Modifier = Modifier,
    currencyList: List<CurrencyItemState>,
    onEvent: (CurrencyListEvent) -> Unit = {}
) {

    LazyColumn(
        modifier = modifier,
        content = {

            items(currencyList) { item ->

            CurrencyListItem(
                currencyName = item.currencyName,
                currencySymbol = item.currencySymbol,
                defaultCurrency = item.defaultCurrency,
                onClick = { onEvent(CurrencyListEvent.OnSelectCurrency(item.currencyId)) }
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
                currencyId = 0,
                currencyName = "Brazilian Real",
                currencySymbol = "R$",
                defaultCurrency = false
            ),
            CurrencyItemState(
                currencyId = 0,
                currencyName = "US Dollar",
                currencySymbol = "$",
                defaultCurrency = true
            ),
            CurrencyItemState(
                currencyId = 0,
                currencyName = "Euro",
                currencySymbol = "€",
                defaultCurrency = false
            )
        )
    )
}