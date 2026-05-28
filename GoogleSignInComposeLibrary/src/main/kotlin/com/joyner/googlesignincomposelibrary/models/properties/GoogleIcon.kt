package com.joyner.googlesignincomposelibrary.models.properties

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class GoogleIcon {
    data class WithResource(@field:DrawableRes val id: Int) : GoogleIcon()
    data class WithVector(val imageVector: ImageVector) : GoogleIcon()
    class WithPainter(val painter: Painter) : GoogleIcon()
}
