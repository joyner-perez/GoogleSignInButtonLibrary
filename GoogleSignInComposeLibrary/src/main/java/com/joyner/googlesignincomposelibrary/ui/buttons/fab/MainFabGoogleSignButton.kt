package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.FabExtended
import com.joyner.googlesignincomposelibrary.models.types.LargeFab
import com.joyner.googlesignincomposelibrary.models.types.SmallFab

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
