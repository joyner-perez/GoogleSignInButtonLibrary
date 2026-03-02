package com.joyner.googlesignincomposelibrary.ui.buttons.fab

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.joyner.googlesignincomposelibrary.models.properties.FabButtonProperties
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.FabExtended
import com.joyner.googlesignincomposelibrary.models.types.LargeFab
import com.joyner.googlesignincomposelibrary.models.types.SmallFab

@Composable
internal fun MainFabGoogleSignButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Fab(),
    showIcon: Boolean = true,
    isLoading: Boolean = false
) {
    when (buttonType) {
        is Fab -> GoogleSignButtonFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            isLoading = isLoading,
            onClick = onClick
        )

        is SmallFab -> GoogleSignButtonSmallFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            isLoading = isLoading,
            onClick = onClick
        )

        is LargeFab -> GoogleSignButtonLargeFab(
            modifier = modifier,
            fabButtonProperties = buttonType.fabButtonProperties,
            isLoading = isLoading,
            onClick = onClick
        )

        is FabExtended -> GoogleSignButtonExtendedFab(
            modifier = modifier,
            fabExtendedButtonProperties = buttonType.fabExtendedButtonProperties,
            showIcon = showIcon,
            isLoading = isLoading,
            onClick = onClick
        )

        else -> Unit
    }
}

@Composable
internal fun MainFabGoogleSignButtonContent(
    modifier: Modifier = Modifier,
    fabButtonProperties: FabButtonProperties = FabButtonProperties(),
    iconSize: Dp = 24.dp,
    isLoading: Boolean = false
) {
    Crossfade(
        modifier = modifier,
        targetState = isLoading,
        label = "google_sign_in_fab_loading"
    ) { loading ->
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(iconSize),
                strokeWidth = 2.dp
            )
        } else {
            Icon(
                modifier = Modifier.size(size = iconSize),
                tint = MaterialTheme.colorScheme.primary,
                painter = painterResource(id = fabButtonProperties.googleIcon),
                contentDescription = stringResource(
                    id = fabButtonProperties.googleButtonIconContentDescription
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainFabGoogleSignButtonPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MainFabGoogleSignButton(
            onClick = {}
        )

        MainFabGoogleSignButton(
            buttonType = SmallFab(),
            onClick = {}
        )

        MainFabGoogleSignButton(
            buttonType = LargeFab(),
            onClick = {}
        )

        MainFabGoogleSignButton(
            buttonType = FabExtended(),
            onClick = {}
        )
    }
}
