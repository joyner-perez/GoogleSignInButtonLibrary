package com.joyner.googlesignincomposelibrary.ui

import androidx.compose.material3.MaterialTheme
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
import com.joyner.googlesignincomposelibrary.ui.buttons.common.GoogleSignButtonElevated
import com.joyner.googlesignincomposelibrary.ui.buttons.common.GoogleSignButtonFilled
import com.joyner.googlesignincomposelibrary.ui.buttons.common.GoogleSignButtonFilledTonal
import com.joyner.googlesignincomposelibrary.ui.buttons.common.GoogleSignButtonOutlined
import com.joyner.googlesignincomposelibrary.ui.buttons.common.GoogleSignButtonText
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.GoogleSignButtonExtendedFab
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.GoogleSignButtonFab
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.GoogleSignButtonLargeFab
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.GoogleSignButtonSmallFab

@Composable
fun GoogleSignButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Elevated(),
    enabled: Boolean = true,
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    when (buttonType) {
        is Elevated -> GoogleSignButtonElevated(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClick
        )
        is Filled -> GoogleSignButtonFilled(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClick
        )
        is FilledTonal -> GoogleSignButtonFilledTonal(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            showIcon = showIcon,
            onClick = onClick
        )
        is Outlined -> GoogleSignButtonOutlined(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            showIcon = showIcon,
            onClick = onClick
        )
        is Text -> GoogleSignButtonText(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            showIcon = showIcon,
            onClick = onClick
        )
        is Fab -> GoogleSignButtonFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties.copy(
                googleIconSize = 24,
                googleIconColor = MaterialTheme.colorScheme.primary
            ),
            onClick = onClick
        )
        is SmallFab -> GoogleSignButtonSmallFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties.copy(
                googleIcon = buttonType.fabButtonProperties.googleIcon,
                googleIconSize = 24,
                googleIconColor = MaterialTheme.colorScheme.primary
            ),
            onClick = onClick
        )
        is LargeFab -> GoogleSignButtonLargeFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties.copy(
                googleIconSize = 24,
                googleIconColor = MaterialTheme.colorScheme.primary
            ),
            onClick = onClick
        )
        is FabExtended -> GoogleSignButtonExtendedFab(
            modifier = modifier,
            fabExtendedButtonProperties = buttonType.fabExtendedButtonProperties.copy(
                googleIconSize = 24,
                googleIconColor = MaterialTheme.colorScheme.primary,
                spaceBetweenIconAndText = 16
            ),
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
