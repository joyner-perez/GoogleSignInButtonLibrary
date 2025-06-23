package com.joyner.googlesignincomposelibrary.models.properties

import androidx.compose.ui.graphics.Color
import com.joyner.googlesignincomposelibrary.R

/**
 * CommonButtonProperties.
 *
 * Properties for the common button that you can use in your Google Sign In.
 *
 * @param googleIconColor [Color] color of the icon. Default is [Color.Unspecified].
 * @param googleButtonText [Int] resource of string. Default is [R.string.button_login_google].
 * @param googleButtonTextSize [Int] size of text. Default is 14.sp.
 * @param googleIconSize [Int]. size of the icon. Default is 18.dp.
 * @param spaceBetweenIconAndText [Int] space between the icon and text. Default is 8.dp.
 * @param textButtonColor [Color] color of the text. Default is [Color.Unspecified].
 * @author Joyner
 */
data class CommonButtonProperties(
    val googleIconColor: Color = Color.Unspecified,
    val googleButtonText: Int = R.string.button_login_google,
    val googleButtonTextSize: Int = 14,
    val googleIconSize: Int = 18,
    val spaceBetweenIconAndText: Int = 8,
    val textButtonColor: Color = Color.Unspecified
) : ButtonProperties()
