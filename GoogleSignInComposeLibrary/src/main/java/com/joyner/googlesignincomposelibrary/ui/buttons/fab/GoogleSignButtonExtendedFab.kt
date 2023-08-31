package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.FabExtendedButtonProperties

@Composable
internal fun GoogleSignButtonExtendedFab(
    modifier: Modifier = Modifier,
    fabExtendedButtonProperties: FabExtendedButtonProperties = FabExtendedButtonProperties(),
    showIcon: Boolean = true,
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() },
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    if (showIcon) {
                        Icon(
                            modifier = Modifier
                                .padding(end = fabExtendedButtonProperties.spaceBetweenIconAndText.dp)
                                .size(fabExtendedButtonProperties.googleIconSize.dp),
                            tint = fabExtendedButtonProperties.googleIconColor,
                            painter = painterResource(id = fabExtendedButtonProperties.googleIcon),
                            contentDescription = "LogoGoogle"
                        )
                    }
                    Text(
                        text = stringResource(id = fabExtendedButtonProperties.googleButtonText),
                        color = fabExtendedButtonProperties.googleIconColor
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
fun GoogleSignButtonExtendedFabPreview() {
    GoogleSignButtonExtendedFab(
        onClick = {}
    )
}
