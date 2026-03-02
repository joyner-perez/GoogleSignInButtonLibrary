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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joyner.googlesignincomposelibrary.models.properties.FabExtendedButtonProperties

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
                    if (showIcon) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(size = 24.dp),
                            tint = fabExtendedButtonProperties.googleIconColor,
                            painter = painterResource(
                                id = fabExtendedButtonProperties.googleIcon
                            ),
                            contentDescription = stringResource(
                                id = fabExtendedButtonProperties.googleButtonIconContentDescription
                            )
                        )
                    }
                    Text(
                        text = stringResource(id = fabExtendedButtonProperties.googleButtonText),
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
