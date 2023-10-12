package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.enums.ButtonType
import com.joyner.googlesignincomposelibrary.enums.Fab
import com.joyner.googlesignincomposelibrary.enums.FabExtended
import com.joyner.googlesignincomposelibrary.enums.LargeFab
import com.joyner.googlesignincomposelibrary.enums.SmallFab

@Composable
internal fun MainFabGoogleSignButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Fab(),
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    when (buttonType) {
        is Fab -> GoogleSignButtonFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            onClick = onClick
        )
        is SmallFab -> GoogleSignButtonSmallFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            onClick = onClick
        )
        is LargeFab -> GoogleSignButtonLargeFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            onClick = onClick
        )
        is FabExtended -> GoogleSignButtonExtendedFab(
            modifier = modifier,
            fabExtendedButtonProperties = buttonType.fabExtendedButtonProperties,
            showIcon = showIcon,
            onClick = onClick
        )

        else -> Unit
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainFabGoogleSignButtonPreview() {
    MainFabGoogleSignButton(
        onClick = {}
    )
}
