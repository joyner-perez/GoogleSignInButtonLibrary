package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties

@Composable
internal fun GoogleSignButtonFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fabButtonProperties: FabButtonProperties = FabButtonProperties(),
    isLoading: Boolean = false
) {
    FloatingActionButton(
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
private fun GoogleSignButtonFabPreview() {
    GoogleSignButtonFab(
        onClick = {}
    )
}
