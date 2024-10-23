package com.joyner.googlesignincomposelibrary.models.properties

import com.joyner.googlesignincomposelibrary.R

data class FabExtendedButtonProperties(
    val googleButtonText: Int = R.string.button_login_google,
    val googleButtonTextSize: Int = 14
) : FabButtonProperties()
