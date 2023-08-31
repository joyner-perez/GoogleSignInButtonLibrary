package com.joyner.googlesignincomposelibrary.enums

import com.joyner.googlesignincomposelibrary.models.FabButtonProperties
import com.joyner.googlesignincomposelibrary.models.FabExtendedButtonProperties

sealed class FabButtonType : ButtonType()

data class Fab(
    val fabButtonProperties: FabButtonProperties = FabButtonProperties()
) : FabButtonType()

data class SmallFab(
    val fabButtonProperties: FabButtonProperties = FabButtonProperties()
) : FabButtonType()

data class LargeFab(
    val fabButtonProperties: FabButtonProperties = FabButtonProperties()
) : FabButtonType()

data class FabExtended(
    val fabExtendedButtonProperties: FabExtendedButtonProperties = FabExtendedButtonProperties()
) : FabButtonType()
