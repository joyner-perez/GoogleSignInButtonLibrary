package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import com.joyner.googlesignincomposelibrary.models.types.IconFilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconOutlined
import com.joyner.googlesignincomposelibrary.models.types.IconStandard

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainIconGoogleSignButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MainIconGoogleSignButton(
            onClick = {}
        )

        MainIconGoogleSignButton(
            buttonType = IconFilled(),
            onClick = {}
        )

        MainIconGoogleSignButton(
            buttonType = IconFilledTonal(),
            onClick = {}
        )

        MainIconGoogleSignButton(
            buttonType = IconOutlined(),
            onClick = {}
        )
    }
}
