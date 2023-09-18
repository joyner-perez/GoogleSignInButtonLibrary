package com.joyner.googlesignincomposelibrary.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.enums.ButtonType
import com.joyner.googlesignincomposelibrary.enums.Elevated
import com.joyner.googlesignincomposelibrary.enums.Fab
import com.joyner.googlesignincomposelibrary.enums.FabExtended
import com.joyner.googlesignincomposelibrary.enums.Filled
import com.joyner.googlesignincomposelibrary.enums.FilledTonal
import com.joyner.googlesignincomposelibrary.enums.LargeFab
import com.joyner.googlesignincomposelibrary.enums.Outlined
import com.joyner.googlesignincomposelibrary.enums.SmallFab
import com.joyner.googlesignincomposelibrary.enums.Text
import com.joyner.googlesignincomposelibrary.ui.buttons.common.MainCommonGoogleSignButton
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.MainFabGoogleSignButton

@Composable
fun GoogleSignButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Elevated(),
    enabled: Boolean = true,
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    when (buttonType) {
        is Elevated, is Filled, is FilledTonal, is Outlined, is Text -> MainCommonGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClick
        )
        is Fab, is SmallFab, is LargeFab, is FabExtended -> MainFabGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            showIcon = showIcon,
            onClick = onClick
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFF002022
)
@Composable
fun GoogleSignButtonPreview() {
    GoogleSignButton(
        onClick = {}
    )
}
