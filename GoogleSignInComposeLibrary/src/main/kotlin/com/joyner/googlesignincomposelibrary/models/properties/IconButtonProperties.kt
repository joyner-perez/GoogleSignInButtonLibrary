package com.joyner.googlesignincomposelibrary.models.properties

import com.joyner.googlesignincomposelibrary.R

/**
 * IconButtonProperties.
 *
 * Properties for the common button that you can use in your Google Sign In.
 *
 * @param googleButtonIconContentDescription [Int] resource of string.
 * Default is [R.string.default_icon_google_content_description].
 * @param googleIcon [Int] resource of icon if you need use other.
 * Default is [R.drawable.ic_google_button].
 * @author Joyner
 */
open class IconButtonProperties(
    val googleButtonIconContentDescription: GoogleText = GoogleText.Resource(
        R.string.default_icon_google_content_description
    ),
    override val googleIcon: GoogleIcon = GoogleIcon.WithResource(R.drawable.ic_google_button)
) : ButtonProperties(googleIcon = googleIcon)
