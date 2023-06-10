package com.douglasqueiroz.thewallet.feature.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.ui.components.BottomBar
import com.douglasqueiroz.thewallet.ui.components.BottomBarItem
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onBottomBarClick: (BottomBarItem) -> Unit = {  }
) {
    Scaffold(
        bottomBar = {
            BottomBar(onBottomBarClick = onBottomBarClick)
        }
    ) {

        Text(
            modifier = Modifier.padding(it),
            text = "Home Screen"
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    TheWalletTheme {
        Surface {
            HomeScreen()
        }
    }
}