package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.enums.ButtonType
import com.joyner.googlesignincomposelibrary.enums.IconFilled
import com.joyner.googlesignincomposelibrary.enums.IconFilledTonal
import com.joyner.googlesignincomposelibrary.enums.IconOutlined
import com.joyner.googlesignincomposelibrary.enums.IconStandard

@Composable
internal fun MainIconGoogleSignButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = IconStandard(),
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    when (buttonType) {
        is IconFilled -> GoogleSignIconButtonFilled(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            onClick = onClick
        )
        is IconFilledTonal -> GoogleSignIconButtonFilledTonal(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            onClick = onClick
        )
        is IconOutlined -> GoogleSignIconButtonOutlined(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            onClick = onClick
        )
        is IconStandard -> GoogleSignIconButtonStandard(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
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
fun MainIconGoogleSignButtonPreview() {
    MainIconGoogleSignButton(
        onClick = {}
    )
}
