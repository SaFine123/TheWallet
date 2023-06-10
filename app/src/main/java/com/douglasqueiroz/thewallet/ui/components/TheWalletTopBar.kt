package com.douglasqueiroz.thewallet.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.douglasqueiroz.thewallet.R
import com.douglasqueiroz.thewallet.ui.navigation.NavRouter

@Composable
fun TheWalletTopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.app_name,
    navigateUp: (() -> Unit)? = null
) {

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = title)
            )
        },
        navigationIcon = {
            if (navigateUp != null) {
                IconButton(onClick = {
                    navigateUp()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colors.background
                    )
                }
            }
        }
    )

}

@Preview
@Composable
fun TheWalletTopBarPreview() {
    TheWalletTopBar()
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TheWalletTopBarDarkPreview() {
    TheWalletTopBar()
}

@Preview
@Composable
fun TheWalletTopBarWithBackPreview() {
    TheWalletTopBar(navigateUp = { })
}

interface OnTopBarClick {
    fun navigateUp()
}

class OnTopBarClickImp(
    private val navRouter: NavRouter
): OnTopBarClick {
    override fun navigateUp() {
        navRouter.navigateUp()
    }
}