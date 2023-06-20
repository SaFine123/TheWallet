package com.douglasqueiroz.thewallet.feature.currencydetails.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.feature.currencydetails.logic.CurrencyDetailsViewState
import com.douglasqueiroz.thewallet.feature.currencylist.logic.CurrencyDetailsEvent
import com.douglasqueiroz.thewallet.ui.components.TheWalletTextField

@Composable
fun CurrencyDetailsView(
    modifier: Modifier = Modifier,
    state: CurrencyDetailsViewState,
    onEvent: (CurrencyDetailsEvent) -> Unit
) {

    Dialog(
        onDismissRequest = { onEvent(CurrencyDetailsEvent.OnCancel)  }
    ) {
        Surface (
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Column(modifier = modifier.padding(20.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.currency_details_title),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    IconButton(onClick = { onEvent(CurrencyDetailsEvent.OnCancel) }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                        )
                    }
                }

                TheWalletTextField(
                    title = stringResource(id = R.string.currency_details_name_label),
                    text = state.currencyName,
                    errorMsg = state.currencyNameErrorMsg,
                    onValueChange = {
                        onEvent(CurrencyDetailsEvent.OnNameChange(it))
                    }
                )

                TheWalletTextField(
                    title = stringResource(id = R.string.currency_details_symbol_label),
                    text = state.currencySymbol,
                    errorMsg = state.currencySymbolErrorMsg,
                    onValueChange = {
                        onEvent(CurrencyDetailsEvent.OnSymbolChange(it))
                    }
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = state.defaultCurrency,
                        onCheckedChange = {
                            onEvent(CurrencyDetailsEvent.OnDefaultCurrencyChange(it))
                        }
                    )

                    Text(
                        text = stringResource(id = R.string.currency_details_default_currency_label),
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Button(
                    shape = RoundedCornerShape(50.dp),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {
                        onEvent(CurrencyDetailsEvent.OnSave)
                    },
                    enabled = state.enableSave
                ) {
                    Text(text = stringResource(id = R.string.save))
                }
            }
        }
    }
}

@Preview
@Composable
fun CurrencyDetailsViewPreview() {

    CurrencyDetailsView(
        state = CurrencyDetailsViewState(),
        onEvent = {}
    )
}