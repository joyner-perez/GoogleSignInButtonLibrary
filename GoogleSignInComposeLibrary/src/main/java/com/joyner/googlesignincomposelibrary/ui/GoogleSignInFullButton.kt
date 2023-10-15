package com.joyner.googlesignincomposelibrary.ui

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.joyner.googlesignincomposelibrary.models.FullIntegrationResult
import com.joyner.googlesignincomposelibrary.models.types.ButtonType
import com.joyner.googlesignincomposelibrary.models.types.Elevated
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.FabExtended
import com.joyner.googlesignincomposelibrary.models.types.Filled
import com.joyner.googlesignincomposelibrary.models.types.FilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import com.joyner.googlesignincomposelibrary.models.types.IconFilledTonal
import com.joyner.googlesignincomposelibrary.models.types.IconOutlined
import com.joyner.googlesignincomposelibrary.models.types.IconStandard
import com.joyner.googlesignincomposelibrary.models.types.LargeFab
import com.joyner.googlesignincomposelibrary.models.types.Outlined
import com.joyner.googlesignincomposelibrary.models.types.SmallFab
import com.joyner.googlesignincomposelibrary.models.types.Text
import com.joyner.googlesignincomposelibrary.ui.buttons.common.MainCommonGoogleSignButton
import com.joyner.googlesignincomposelibrary.ui.buttons.fab.MainFabGoogleSignButton
import com.joyner.googlesignincomposelibrary.ui.buttons.icon.MainIconGoogleSignButton

/**
 * GoogleSignInFullButton.
 *
 * It is the implementation using Google services, you only have to take
 * care of the navigation when you receive the response.
 *
 * @param modifier modifier if you need to add.
 * @param buttonType type of button you need. Example: Elevated, Filled,
 *     FilledTonal, Outlined, Text, Fab, SmallFab, LargeFab, FabExtended,
 *     IconFilled, IconFilledTonal, IconOutlined, IconStandard.
 * @param enabled if you need the button to be enabled or disabled.
 * @param showIcon if you need the icon button to be show or hide.
 * @param tokenClientId your client id after created your project in
 *     Firebase and configure Google Sign in. Is mandatory.
 * @param onClick event to do what you need, you will receive a
 *     FullIntegrationResult object, which has two properties, result, of
 *     type boolean and token, of type string. If the login was correct,
 *     result will be true and token will have a value other than empty. It
 *     is mandatory.
 * @author Joyner
 */
@Composable
fun GoogleSignInFullButton(
    modifier: Modifier = Modifier,
    buttonType: ButtonType = Elevated(),
    enabled: Boolean = true,
    showIcon: Boolean = true,
    tokenClientId: String,
    onClick: (fullIntegrationResult: FullIntegrationResult) -> Unit
) {
    val context = LocalContext.current

    val googleSignInClient by remember {
        mutableStateOf(
            initGoogleSignInClient(
                context = context,
                tokenClientId = tokenClientId
            )
        )
    }

    val launcherForActivity =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                try {
                    val account = task.getResult(ApiException::class.java)
                    onClick(
                        FullIntegrationResult(
                            result = (account.idToken ?: "") != "",
                            idToken = account.idToken ?: ""
                        )
                    )
                } catch (e: ApiException) {
                    Log.e("GoogleSignButtonError", e.message ?: "Error")
                    onClick(FullIntegrationResult())
                }
            } else {
                onClick(FullIntegrationResult())
            }
        }

    when (buttonType) {
        is Elevated, is Filled, is FilledTonal, is Outlined, is Text -> MainCommonGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            enabled = enabled,
            showIcon = showIcon,
            onClick = { launcherForActivity.launch(googleSignInClient.signInIntent) }
        )

        is Fab, is SmallFab, is LargeFab, is FabExtended -> MainFabGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            showIcon = showIcon,
            onClick = { launcherForActivity.launch(googleSignInClient.signInIntent) }
        )

        is IconFilled, is IconFilledTonal, is IconOutlined, is IconStandard -> MainIconGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            enabled = enabled,
            onClick = { launcherForActivity.launch(googleSignInClient.signInIntent) }
        )
    }
}

private fun initGoogleSignInClient(context: Context, tokenClientId: String): GoogleSignInClient =
    GoogleSignIn.getClient(
        context,
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(tokenClientId)
            .requestId()
            .requestProfile()
            .build()
    )

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFF002022
)
@Composable
fun GoogleSignInFullButton() {
    GoogleSignInFullButton(
        tokenClientId = "",
        onClick = {}
    )
}
