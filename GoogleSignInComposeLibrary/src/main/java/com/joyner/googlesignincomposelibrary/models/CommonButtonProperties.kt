package com.joyner.googlesignincomposelibrary.models

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

data class CommonButtonProperties(
    val googleIcon: Int = R.drawable.ic_google_button,
    val googleIconColor: Color = Color.Unspecified,
    val googleButtonText: Int = R.string.button_login_google,
    val googleButtonTextSize: Int = 14,
    val googleIconSize: Int = 18,
    val spaceBetweenIconAndText: Int = 24
)
