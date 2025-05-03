package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.properties.IconButtonProperties

@Composable
internal fun GoogleSignIconButtonFilled(
    modifier: Modifier = Modifier,
    iconButtonProperties: IconButtonProperties = IconButtonProperties(),
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    FilledIconButton(
        modifier = modifier
            .wrapContentSize(),
        enabled = enabled,
        onClick = { onClick() },
        content = {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(id = iconButtonProperties.googleIcon),
                contentDescription = "LogoGoogle"
            )
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignIconButtonFilledPreview() {
    GoogleSignIconButtonFilled(
        onClick = {}
    )
}
