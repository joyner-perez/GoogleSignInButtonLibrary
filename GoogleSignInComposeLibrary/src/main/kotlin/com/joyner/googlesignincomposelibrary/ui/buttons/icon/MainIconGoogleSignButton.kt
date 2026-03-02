package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.properties.IconButtonProperties
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import com.joyner.googlesignincomposelibrary.models.types.IconFilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconOutlined
import com.joyner.googlesignincomposelibrary.models.types.IconStandard

@Composable
internal fun MainIconGoogleSignButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = IconStandard(),
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    when (buttonType) {
        is IconFilled -> GoogleSignIconButtonFilled(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            isLoading = isLoading,
            onClick = onClick
        )

        is IconFilledTonal -> GoogleSignIconButtonFilledTonal(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            isLoading = isLoading,
            onClick = onClick
        )

        is IconOutlined -> GoogleSignIconButtonOutlined(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            isLoading = isLoading,
            onClick = onClick
        )

        is IconStandard -> GoogleSignIconButtonStandard(
            modifier = modifier,
            iconButtonProperties = buttonType.iconButtonProperties,
            enabled = enabled,
            isLoading = isLoading,
            onClick = onClick
        )

        else -> Unit
    }
}

@Composable
internal fun MainIconGoogleSignButtonContent(
    iconButtonProperties: IconButtonProperties = IconButtonProperties(),
    isLoading: Boolean = false
) {
    Crossfade(
        targetState = isLoading,
        label = "google_sign_in_icon_loading"
    ) { loading ->
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                strokeWidth = 2.dp
            )
        } else {
            Icon(
                modifier = Modifier.size(size = 24.dp),
                painter = painterResource(id = iconButtonProperties.googleIcon),
                contentDescription = stringResource(
                    id = iconButtonProperties.googleButtonIconContentDescription
                )
            )
        }
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
