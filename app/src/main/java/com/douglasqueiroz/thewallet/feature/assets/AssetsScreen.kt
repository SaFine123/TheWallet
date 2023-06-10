package com.douglasqueiroz.thewallet.feature.assets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.ui.components.BottomBar
import com.douglasqueiroz.thewallet.ui.components.BottomBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssetsScreen(
    modifier: Modifier = Modifier,
    onBottomBarClick: (BottomBarItem) -> Unit = {  }
) {
    Scaffold(
        bottomBar = {
            BottomBar(onBottomBarClick = onBottomBarClick)
        }
    ) {
        Text(
            modifier = modifier.padding(it),
            text = "Assets"
        )
    }
}

@Preview
@Composable
fun AssetsScreenPreview() {
    AssetsScreen()
}