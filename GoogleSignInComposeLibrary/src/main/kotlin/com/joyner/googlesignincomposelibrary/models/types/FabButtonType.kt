package com.joyner.googlesignincomposelibrary.models.types

import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties
import com.joyner.googlesignincomposelibrary.models.properties.FabExtendedButtonProperties

sealed class FabButtonType : ButtonType()

data class Fab(val fabButtonProperties: FabButtonProperties = FabButtonProperties()) :
    FabButtonType()

data class SmallFab(val fabButtonProperties: FabButtonProperties = FabButtonProperties()) :
    FabButtonType()

data class LargeFab(val fabButtonProperties: FabButtonProperties = FabButtonProperties()) :
    FabButtonType()

data class FabExtended(
    val fabExtendedButtonProperties: FabExtendedButtonProperties = FabExtendedButtonProperties()
) : FabButtonType()
