package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joyner.googlesignincomposelibrary.models.properties.FabExtendedButtonProperties
import com.joyner.googlesignincomposelibrary.models.properties.GoogleIcon
import com.joyner.googlesignincomposelibrary.models.properties.GoogleText

@Composable
internal fun GoogleSignButtonExtendedFab(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fabExtendedButtonProperties: FabExtendedButtonProperties = FabExtendedButtonProperties(),
    showIcon: Boolean = true,
    isLoading: Boolean = false
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        Crossfade(
            targetState = isLoading,
            label = "google_sign_in_extended_fab_loading"
        ) { loading ->
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val iconPainter = when (val icon = fabExtendedButtonProperties.googleIcon) {
                        is GoogleIcon.WithResource -> painterResource(icon.id)
                        is GoogleIcon.WithVector -> rememberVectorPainter(icon.imageVector)
                        is GoogleIcon.WithPainter -> icon.painter
                    }
                    val iconContentDesc = when (
                        val t = fabExtendedButtonProperties.googleButtonIconContentDescription
                    ) {
                        is GoogleText.Resource -> stringResource(t.id)
                        is GoogleText.Value -> t.text
                    }
                    val buttonText = when (val t = fabExtendedButtonProperties.googleButtonText) {
                        is GoogleText.Resource -> stringResource(t.id)
                        is GoogleText.Value -> t.text
                    }
                    if (showIcon) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(size = 24.dp),
                            tint = fabExtendedButtonProperties.googleIconColor,
                            painter = iconPainter,
                            contentDescription = iconContentDesc
                        )
                    }
                    Text(
                        text = buttonText,
                        fontSize = fabExtendedButtonProperties.googleButtonTextSize.sp,
                        color = fabExtendedButtonProperties.textButtonColor
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GoogleSignButtonExtendedFabPreview() {
    GoogleSignButtonExtendedFab(
        onClick = {}
    )
}
