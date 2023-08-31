package com.joyner.googlesignincomposelibrary.models

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

data class FabButtonProperties(
    val googleIcon: Int = R.drawable.ic_google_button,
    val googleIconColor: Color = Color.Unspecified,
    val googleIconSize: Int = 24
)
