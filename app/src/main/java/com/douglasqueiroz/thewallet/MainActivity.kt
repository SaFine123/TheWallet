package com.douglasqueiroz.thewallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.douglasqueiroz.thewallet.feature.home.BottomBar
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter
import com.douglasqueiroz.thewallet.ui.navigation.TheWalletNavHost
import com.douglasqueiroz.thewallet.ui.theme.TheWalletTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navRouter: NavRouter by inject()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            val navController = rememberNavController()
            navRouter.navHostController = navController

            TheWalletTheme {
                Scaffold(
                    bottomBar = {
                        BottomBar(navController = navController)
                    }
                ) {
                    TheWalletNavHost(
                        navController = navController,
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}