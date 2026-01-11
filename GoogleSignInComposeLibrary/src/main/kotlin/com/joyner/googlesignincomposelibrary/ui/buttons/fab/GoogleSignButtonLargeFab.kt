package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties

@Composable
internal fun GoogleSignButtonLargeFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fabButtonProperties: FabButtonProperties = FabButtonProperties()
) {
    LargeFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        MainFabGoogleSignButtonContent(fabButtonProperties = fabButtonProperties, iconSize = 36.dp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignButtonLargeFabPreview() {
    GoogleSignButtonLargeFab(
        onClick = {}
    )
}
