package com.joyner.googlesignincomposelibrary.models.properties

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

data class CommonButtonProperties(
    val googleIconColor: Color = Color.Unspecified,
    val googleButtonText: Int = R.string.button_login_google,
    val googleButtonTextSize: Int = 14,
    val googleIconSize: Int = 18,
    val spaceBetweenIconAndText: Int = 8
) : ButtonProperties()
