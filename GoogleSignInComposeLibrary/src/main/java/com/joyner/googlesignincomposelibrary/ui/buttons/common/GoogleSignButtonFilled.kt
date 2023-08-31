package com.joyner.googlesignincomposelibrary.ui.buttons.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.CommonButtonProperties

@Composable
internal fun GoogleSignButtonFilled(
    modifier: Modifier = Modifier,
    commonButtonProperties: CommonButtonProperties = CommonButtonProperties(),
    enabled: Boolean = true,
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .wrapContentSize(),
        enabled = enabled,
        onClick = { onClick() },
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    if (showIcon) {
                        Icon(
                            modifier = Modifier
                                .padding(end = commonButtonProperties.spaceBetweenIconAndText.dp)
                                .size(commonButtonProperties.googleIconSize.dp),
                            tint = commonButtonProperties.googleIconColor,
                            painter = painterResource(id = commonButtonProperties.googleIcon),
                            contentDescription = "LogoGoogle"
                        )
                    }
                    Text(
                        text = stringResource(id = commonButtonProperties.googleButtonText),
                    )
                }
            )
        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GoogleSignButtonFilledPreview() {
    GoogleSignButtonFilled(
        onClick = {}
    )
}
