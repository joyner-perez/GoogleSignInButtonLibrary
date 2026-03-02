package com.joyner.googlesignincomposelibrary.ui

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.joyner.googlesignincomposelibrary.models.types.Fab
import com.joyner.googlesignincomposelibrary.models.types.Filled
import com.joyner.googlesignincomposelibrary.models.types.IconFilled
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GoogleSignInFullButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // region Initial rendering

    @Test
    fun default_button_displays_signInText_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(tokenClientId = "test-client-id", onClick = {})
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun default_button_displays_google_icon_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(tokenClientId = "test-client-id", onClick = {})
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun default_button_has_no_spinner_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(tokenClientId = "test-client-id", onClick = {})
        }
        composeTestRule
            .onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertDoesNotExist()
    }

    // endregion

    // region Different button types render correctly initially

    @Test
    fun filled_button_displays_signInText_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(
                tokenClientId = "test-client-id",
                onClick = {},
                buttonType = Filled()
            )
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun fab_button_displays_google_icon_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(
                tokenClientId = "test-client-id",
                onClick = {},
                buttonType = Fab()
            )
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun iconFilled_button_displays_google_icon_initially() {
        composeTestRule.setContent {
            GoogleSignInFullButton(
                tokenClientId = "test-client-id",
                onClick = {},
                buttonType = IconFilled()
            )
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    // endregion

    // region enabled / disabled state

    @Test
    fun disabled_button_is_not_enabled() {
        composeTestRule.setContent {
            GoogleSignInFullButton(
                tokenClientId = "test-client-id",
                onClick = {},
                enabled = false
            )
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsNotEnabled()
    }

    // endregion

    // region showIcon

    @Test
    fun button_hides_google_icon_when_showIcon_false() {
        composeTestRule.setContent {
            GoogleSignInFullButton(
                tokenClientId = "test-client-id",
                onClick = {},
                showIcon = false
            )
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertDoesNotExist()
    }

    // endregion
}
