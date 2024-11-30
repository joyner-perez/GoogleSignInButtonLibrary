package com.joyner.googlesignincomposelibrary.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
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
import java.security.MessageDigest
import java.util.UUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * GoogleSignInFullButton.
 *
 * It is the implementation using Google services, you only have to take
 * care of the navigation when you receive the response.
 *
 * @param modifier modifier if you need to add.
 * @param buttonType type of button you need. Example: Elevated, Filled,
 *    FilledTonal, Outlined, Text, Fab, SmallFab, LargeFab, FabExtended,
 *    IconFilled, IconFilledTonal, IconOutlined, IconStandard.
 * @param enabled if you need the button to be enabled or disabled.
 * @param showIcon if you need the icon button to be show or hide.
 * @param tokenClientId your client id after created your project in
 *    Firebase and configure Google Sign in. Is mandatory.
 * @param onClick event to do what you need, you will receive a
 *    FullIntegrationResult object, which has two properties, result, of
 *    type boolean and token, of type string. If the login was correct,
 *    result will be true and token will have a value other than empty. It
 *    is mandatory.
 * @author Joyner
 */
@Composable
fun GoogleSignInFullButton(
    buttonType: ButtonType = Elevated(),
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    showIcon: Boolean = true,
    tokenClientId: String,
    onClick: (fullIntegrationResult: FullIntegrationResult) -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val onClickButton: () -> Unit = {
        makeLogin(
            context = context,
            coroutineScope = coroutineScope,
            tokenClientId = tokenClientId,
            onClick = onClick
        )
    }

    when (buttonType) {
        is Elevated, is Filled, is FilledTonal, is Outlined, is Text -> MainCommonGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            enabled = enabled,
            showIcon = showIcon,
            onClick = onClickButton
        )

        is Fab, is SmallFab, is LargeFab, is FabExtended -> MainFabGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            showIcon = showIcon,
            onClick = onClickButton
        )

        is IconFilled,
        is IconFilledTonal,
        is IconOutlined,
        is IconStandard -> MainIconGoogleSignButton(
            modifier = modifier,
            buttonType = buttonType,
            enabled = enabled,
            onClick = onClickButton
        )
    }
}

private fun createGoogleIdOption(tokenClientId: String): GetGoogleIdOption? = runCatching {
    val randomNonce = UUID.randomUUID().toString()
    val bytes = randomNonce.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    val hashNonce = digest.fold("") { str, args -> str + "%02x".format(args) }

    GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setServerClientId(tokenClientId)
        .setAutoSelectEnabled(true)
        .setNonce(hashNonce)
        .build()
}.fold(
    onSuccess = {
        it
    },
    onFailure = {
        null
    }
)

private fun makeLogin(
    context: Context,
    coroutineScope: CoroutineScope,
    tokenClientId: String,
    onClick: (FullIntegrationResult) -> Unit
) {
    val credentialManager = CredentialManager.create(context)
    val googleIdOption = createGoogleIdOption(tokenClientId)
    if (googleIdOption == null) {
        onClick(
            FullIntegrationResult(
                result = false,
                idToken = ""
            )
        )
    } else {
        runCatching {
            GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()
        }.fold(
            onSuccess = {
                coroutineScope.launch {
                    runCatching {
                        val result = credentialManager.getCredential(
                            request = it,
                            context = context
                        )
                        val credential = result.credential
                        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(
                            data = credential.data
                        )
                        googleIdTokenCredential.idToken
                    }.fold(
                        onSuccess = {
                            onClick(
                                FullIntegrationResult(
                                    result = true,
                                    idToken = it
                                )
                            )
                        },
                        onFailure = {
                            onClick(
                                FullIntegrationResult(
                                    result = false,
                                    idToken = ""
                                )
                            )
                        }
                    )
                }
            },
            onFailure = {
                onClick(
                    FullIntegrationResult(
                        result = false,
                        idToken = ""
                    )
                )
            }
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFF002022
)
@Composable
fun GoogleSignInFullButtonPreview() {
    GoogleSignInFullButton(
        tokenClientId = "",
        onClick = {}
    )
}
