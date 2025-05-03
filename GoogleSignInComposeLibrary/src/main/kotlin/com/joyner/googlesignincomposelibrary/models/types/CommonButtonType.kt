package com.joyner.googlesignincomposelibrary.models.types

import com.joyner.googlesignincomposelibrary.models.properties.CommonButtonProperties

sealed class CommonButtonType : ButtonType()

data class Elevated(val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()) :
    CommonButtonType()

data class Filled(val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()) :
    CommonButtonType()

data class FilledTonal(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()

data class Outlined(val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()) :
    CommonButtonType()

data class Text(val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()) :
    CommonButtonType()
