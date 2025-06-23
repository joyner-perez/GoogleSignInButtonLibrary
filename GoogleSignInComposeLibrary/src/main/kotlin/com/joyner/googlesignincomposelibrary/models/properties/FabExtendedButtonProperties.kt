package com.joyner.googlesignincomposelibrary.models.properties

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

/**
 * FabExtendedButtonProperties.
 *
 * Properties for the FAB button that you can use in your Google Sign In.
 *
 * @param googleIconColor [Color] color of the icon. Default is [Color.Unspecified].
 * @param googleButtonText [Int] resource of string. Default is [R.string.button_login_google].
 * @param googleButtonTextSize [Int] size of text. Default is 14.sp.
 * @param textButtonColor [Color] color of the text. Default is [Color.Unspecified].
 * @author Joyner
 */
data class FabExtendedButtonProperties(
    val googleButtonText: Int = R.string.button_login_google,
    val googleButtonTextSize: Int = 14,
    val googleIconColor: Color = Color.Unspecified,
    val textButtonColor: Color = Color.Unspecified
) : FabButtonProperties()
