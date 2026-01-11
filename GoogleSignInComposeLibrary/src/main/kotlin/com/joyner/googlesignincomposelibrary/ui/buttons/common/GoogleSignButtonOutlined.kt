package com.joyner.googlesignincomposelibrary.ui.buttons.common

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.properties.CommonButtonProperties

@Composable
internal fun GoogleSignButtonOutlined(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    commonButtonProperties: CommonButtonProperties = CommonButtonProperties(),
    enabled: Boolean = true,
    showIcon: Boolean = true
) {
    OutlinedButton(
        modifier = modifier.wrapContentSize(),
        enabled = enabled,
        onClick = { onClick() }
    ) {
        CommonSignButtonContent(
            commonButtonProperties = commonButtonProperties,
            showIcon = showIcon
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignButtonOutlinedPreview() {
    GoogleSignButtonOutlined(
        onClick = {}
    )
}
