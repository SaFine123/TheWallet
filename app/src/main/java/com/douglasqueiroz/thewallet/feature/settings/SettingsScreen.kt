package com.douglasqueiroz.thewallet.feature.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.ui.components.BottomBar
import com.douglasqueiroz.thewallet.ui.components.BottomBarItem
import com.douglasqueiroz.thewallet.ui.components.TheWalletTopBar
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onEvent: (SettingsEvent) -> Unit = {},
    onBottomBarClick: (BottomBarItem) -> Unit = {}
) {
    Scaffold(
        topBar = {
            TheWalletTopBar(
                title = R.string.settings_screen_title
            )
        },
        bottomBar = {
            BottomBar(onBottomBarClick = onBottomBarClick)
        }
    ) {
        Column(modifier = modifier.padding(it)) {

            SettingItem(
                labelId = R.string.currency_list,
                onClick = { onEvent(SettingsEvent.OnCurrencyClick) }
            )

            SettingItem(
                labelId = R.string.currency_list,
                onClick = {  }
            )

            SettingItem(
                labelId = R.string.currency_list,
                onClick = {  }
            )
        }
    }
}

@Composable
fun SettingItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @StringRes labelId: Int
) {

    Row(
        modifier = modifier
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = stringResource(id = labelId),
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    TheWalletTheme {
        SettingsScreen()
    }
}