package com.joyner.googlesignincomposelibrary.models.properties

import com.joyner.googlesignincomposelibrary.R

/**
 * CommonButtonProperties.
 *
 * Properties for all buttons that you can use in your Google Sign In.
 *
 * @param googleIcon [Int] resource of icon if you need use other.
 * Default is [R.drawable.ic_google_button].
 * @author Joyner
 */
sealed class ButtonProperties(val googleIcon: Int = R.drawable.ic_google_button)
