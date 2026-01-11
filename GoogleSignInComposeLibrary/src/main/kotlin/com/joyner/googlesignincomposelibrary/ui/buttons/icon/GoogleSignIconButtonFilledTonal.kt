package com.joyner.googlesignincomposelibrary.ui.buttons.icon

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.properties.IconButtonProperties

@Composable
internal fun GoogleSignIconButtonFilledTonal(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconButtonProperties: IconButtonProperties = IconButtonProperties(),
    enabled: Boolean = true
) {
    FilledTonalIconButton(
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
private fun GoogleSignIconButtonFilledTonalPreview() {
    GoogleSignIconButtonFilledTonal(
        onClick = {}
    )
}
