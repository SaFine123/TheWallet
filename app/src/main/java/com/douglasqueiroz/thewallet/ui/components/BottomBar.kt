package com.douglasqueiroz.thewallet.ui.components

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.feature.assets.navigateToAssets
import com.douglasqueiroz.thewallet.feature.home.navigateToHome
import com.douglasqueiroz.thewallet.feature.settings.navigateToSettings
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onBottomBarClick: (BottomBarItem) -> Unit = {  }
) {

    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background
    ) {

        BottomBarItem.values().forEach { bottomBarItem ->
            BottomNavigationItem(
                selected = false,
                onClick = { onBottomBarClick(bottomBarItem) },
                icon = {
                    Icon(imageVector = bottomBarItem.icon, contentDescription = null)
                },
                label = {
                    Text(stringResource(id = bottomBarItem.label))
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar()
}

enum class BottomBarItem(
    var icon: ImageVector,
    var label: Int
) {
    Home(
        icon = Icons.Default.Home,
        label = R.string.bottom_navigation_home
    ),
    Assets(
        icon = Icons.Default.List,
        label = R.string.botton_navigation_assets
    ),
    Settings(
        icon = Icons.Default.Settings,
        label = R.string.botton_navigation_settings
    );
}

interface OnBottomBarClick {
    fun onBottomBarClick(bottomBarItem: BottomBarItem)
}

class OnBottomBarClickImpl(private val navRouter: NavRouter): OnBottomBarClick {

    override fun onBottomBarClick(bottomBarItem: BottomBarItem) {
        when(bottomBarItem) {
            BottomBarItem.Home -> navRouter.navigateToHome()
            BottomBarItem.Assets -> navRouter.navigateToAssets()
            BottomBarItem.Settings -> navRouter.navigateToSettings()
        }
    }
}