package com.joyner.googlesignincomposelibrary.enums

import com.joyner.googlesignincomposelibrary.models.CommonButtonProperties

sealed class CommonButtonType : ButtonType()

data class Elevated(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()

data class Filled(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()

data class FilledTonal(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()

data class Outlined(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()

data class Text(
    val commonButtonProperties: CommonButtonProperties = CommonButtonProperties()
) : CommonButtonType()
