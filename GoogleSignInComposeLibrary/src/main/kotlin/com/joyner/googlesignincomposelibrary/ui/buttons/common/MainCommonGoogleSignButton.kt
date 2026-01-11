package com.joyner.googlesignincomposelibrary.ui.buttons.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joyner.googlesignincomposelibrary.models.properties.CommonButtonProperties
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.Elevated
import com.joyner.googlesignincomposelibrary.models.types.Filled
import com.joyner.googlesignincomposelibrary.models.types.FilledTonal
import com.joyner.googlesignincomposelibrary.models.types.Outlined
import com.joyner.googlesignincomposelibrary.models.types.Text

@Composable
internal fun MainCommonGoogleSignButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Elevated(),
    enabled: Boolean = true,
    showIcon: Boolean = true
) {
    when (buttonType) {
        is Elevated ->
            GoogleSignButtonElevated(
                modifier = modifier,
                commonButtonProperties = buttonType.commonButtonProperties,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        is Filled ->
            GoogleSignButtonFilled(
                modifier = modifier,
                commonButtonProperties = buttonType.commonButtonProperties,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        is FilledTonal ->
            GoogleSignButtonFilledTonal(
                modifier = modifier,
                commonButtonProperties = buttonType.commonButtonProperties,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        is Outlined ->
            GoogleSignButtonOutlined(
                modifier = modifier,
                commonButtonProperties = buttonType.commonButtonProperties,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        is Text ->
            GoogleSignButtonText(
                modifier = modifier,
                commonButtonProperties = buttonType.commonButtonProperties,
                enabled = enabled,
                showIcon = showIcon,
                onClick = onClick
            )

        else -> Unit
    }
}

@Composable
internal fun CommonSignButtonContent(
    modifier: Modifier = Modifier,
    commonButtonProperties: CommonButtonProperties = CommonButtonProperties(),
    showIcon: Boolean = true
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showIcon) {
            Icon(
                modifier = Modifier
                    .padding(end = commonButtonProperties.spaceBetweenIconAndText.dp)
                    .size(size = commonButtonProperties.googleIconSize.dp),
                tint = commonButtonProperties.googleIconColor,
                painter = painterResource(id = commonButtonProperties.googleIcon),
                contentDescription = stringResource(
                    id = commonButtonProperties.googleButtonIconContentDescription
                )
            )
        }
        Text(
            text = stringResource(id = commonButtonProperties.googleButtonText),
            fontSize = commonButtonProperties.googleButtonTextSize.sp,
            color = commonButtonProperties.textButtonColor
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainCommonGoogleSignButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MainCommonGoogleSignButton(
            onClick = {}
        )

        MainCommonGoogleSignButton(
            buttonType = Filled(),
            onClick = {}
        )

        MainCommonGoogleSignButton(
            buttonType = FilledTonal(),
            onClick = {}
        )

        MainCommonGoogleSignButton(
            buttonType = Outlined(),
            onClick = {}
        )

        MainCommonGoogleSignButton(
            buttonType = Text(),
            onClick = {}
        )
    }
}
