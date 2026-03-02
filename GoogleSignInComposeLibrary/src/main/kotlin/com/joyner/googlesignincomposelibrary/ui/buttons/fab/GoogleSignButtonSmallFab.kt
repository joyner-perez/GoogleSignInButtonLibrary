package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties

@Composable
internal fun GoogleSignButtonSmallFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fabButtonProperties: FabButtonProperties = FabButtonProperties(),
    isLoading: Boolean = false
) {
    SmallFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        MainFabGoogleSignButtonContent(
            fabButtonProperties = fabButtonProperties,
            isLoading = isLoading
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignButtonSmallFabPreview() {
    GoogleSignButtonSmallFab(
        onClick = {}
    )
}
