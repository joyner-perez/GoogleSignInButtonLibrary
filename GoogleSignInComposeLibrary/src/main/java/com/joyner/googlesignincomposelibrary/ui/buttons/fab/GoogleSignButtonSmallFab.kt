package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties

@Composable
internal fun GoogleSignButtonSmallFab(
    modifier: Modifier = Modifier,
    fabButtonProperties: FabButtonProperties = FabButtonProperties(),
    onClick: () -> Unit
) {
    SmallFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() },
        content = {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                tint = MaterialTheme.colorScheme.primary,
                painter = painterResource(id = fabButtonProperties.googleIcon),
                contentDescription = "LogoGoogle"
            )
        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GoogleSignButtonSmallFabPreview() {
    GoogleSignButtonSmallFab(
        onClick = {}
    )
}
