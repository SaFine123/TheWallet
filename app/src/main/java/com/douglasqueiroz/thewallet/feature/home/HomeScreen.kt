package com.douglasqueiroz.thewallet.feature.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.feature.assets.navigateToAssets
import com.douglasqueiroz.thewallet.feature.settings.navigateToSettings
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = "Statistics"
    )
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

    fun navigate(navController: NavHostController) {
        when(this) {
            Home -> navController.navigateToHome()
            Assets -> navController.navigateToAssets()
            Settings -> navController.navigateToSettings()
        }
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    BottomNavigation(
        modifier = modifier,
//        backgroundColor = MaterialTheme.colors.background
    ) {

        BottomBarItem.values().forEach { bottomBarItem ->
            BottomNavigationItem(
                selected = false,
                onClick = { bottomBarItem.navigate(navController = navController) },
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

@Preview(uiMode = UI_MODE_NIGHT_YES, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    TheWalletTheme {
        Surface {
            HomeScreen()
        }
    }
}