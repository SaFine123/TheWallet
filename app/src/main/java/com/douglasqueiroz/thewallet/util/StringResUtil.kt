package com.douglasqueiroz.thewallet.util

import android.content.Context
import androidx.annotation.StringRes

class StringResUtil(
    private val context: Context
) {

    fun getString(@StringRes stringResId: Int) = context.getString(stringResId)
}