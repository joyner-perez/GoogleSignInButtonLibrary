package com.joyner.googlesignincomposelibrary.ui.buttons.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.enums.ButtonType
import com.joyner.googlesignincomposelibrary.enums.Elevated
import com.joyner.googlesignincomposelibrary.enums.Filled
import com.joyner.googlesignincomposelibrary.enums.FilledTonal
import com.joyner.googlesignincomposelibrary.enums.Outlined
import com.joyner.googlesignincomposelibrary.enums.Text

@Composable
internal fun MainCommonGoogleSignButton(
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
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClick
        )
        is Outlined -> GoogleSignButtonOutlined(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClick
        )
        is Text -> GoogleSignButtonText(
            modifier = modifier,
            commonButtonProperties = buttonType.commonButtonProperties,
            enabled = enabled,
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
fun MainCommonGoogleSignButtonPreview() {
    MainCommonGoogleSignButton(
        onClick = {}
    )
}
