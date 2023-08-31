package com.joyner.googlesignincomposelibrary.models

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

data class FabExtendedButtonProperties(
    val googleIcon: Int = R.drawable.ic_google_button,
    val googleButtonText: Int = R.string.button_login_google,
    val googleIconColor: Color = Color.Unspecified,
    val googleIconSize: Int = 24,
    val spaceBetweenIconAndText: Int = 16
)
