package com.joyner.googlesignincomposelibrary.models.types

import com.joyner.googlesignincomposelibrary.models.properties.IconButtonProperties

sealed class IconButtonType : ButtonType()

data class IconFilled(
    val iconButtonProperties: IconButtonProperties = IconButtonProperties()
) : IconButtonType()

data class IconFilledTonal(
    val iconButtonProperties: IconButtonProperties = IconButtonProperties()
) : IconButtonType()

data class IconOutlined(
    val iconButtonProperties: IconButtonProperties = IconButtonProperties()
) : IconButtonType()

data class IconStandard(
    val iconButtonProperties: IconButtonProperties = IconButtonProperties()
) : IconButtonType()
