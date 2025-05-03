package com.joyner.googlesignincomposelibrary.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.Elevated
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.FabExtended
import com.joyner.googlesignincomposelibrary.models.types.Filled
import com.joyner.googlesignincomposelibrary.models.types.FilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import com.joyner.googlesignincomposelibrary.models.types.IconFilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconOutlined
import com.joyner.googlesignincomposelibrary.models.types.IconStandard
import com.joyner.googlesignincomposelibrary.models.types.LargeFab
import com.joyner.googlesignincomposelibrary.models.types.Outlined
import com.joyner.googlesignincomposelibrary.models.types.SmallFab
import com.joyner.googlesignincomposelibrary.models.types.Text
import com.joyner.googlesignincomposelibrary.ui.buttons.common.MainCommonGoogleSignButton
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.MainFabGoogleSignButton
import com.joyner.googlesignincomposelibrary.ui.buttons.icon.MainIconGoogleSignButton

/**
 * GoogleSignButton.
 *
 * It is the implementation without using Google services, you will have to
 * do all the logic on your own
 *
 * @param modifier modifier if you need to add.
 * @param buttonType type of button you need. Example: Elevated, Filled,
 *     FilledTonal, Outlined, Text, Fab, SmallFab, LargeFab, FabExtended,
 *     IconFilled, IconFilledTonal, IconOutlined, IconStandard.
 * @param enabled if you need the button to be enabled or disabled.
 * @param showIcon if you need the icon button to be show or hide.
 * @param onClick event to do what you need. Is mandatory.
 * @author Joyner
 */
@Composable
fun GoogleSignInButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Elevated(),
    enabled: Boolean = true,
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    when (buttonType) {
        is Elevated, is Filled, is FilledTonal, is Outlined, is Text ->
            MainCommonGoogleSignButton(
                modifier = modifier,
                buttonType = buttonType,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        is Fab, is SmallFab, is LargeFab, is FabExtended ->
            MainFabGoogleSignButton(
                modifier = modifier,
                buttonType = buttonType,
                showIcon = showIcon,
                onClick = onClick
            )

        is IconFilled, is IconFilledTonal, is IconOutlined, is IconStandard ->
            MainIconGoogleSignButton(
                modifier = modifier,
                buttonType = buttonType,
                enabled = enabled,
                onClick = onClick
            )
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF002022)
@Composable
private fun GoogleSignInButtonPreview() {
    GoogleSignInButton(
        onClick = {}
    )
}
