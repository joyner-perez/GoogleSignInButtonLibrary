package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FilledIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.properties.IconButtonProperties

@Composable
internal fun GoogleSignIconButtonFilled(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconButtonProperties: IconButtonProperties = IconButtonProperties(),
    enabled: Boolean = true
) {
    FilledIconButton(
        modifier = modifier
            .wrapContentSize(),
        enabled = enabled,
        onClick = { onClick() }
    ) {
        MainIconGoogleSignButtonContent(iconButtonProperties = iconButtonProperties)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignIconButtonFilledPreview() {
    GoogleSignIconButtonFilled(
        onClick = {}
    )
}
