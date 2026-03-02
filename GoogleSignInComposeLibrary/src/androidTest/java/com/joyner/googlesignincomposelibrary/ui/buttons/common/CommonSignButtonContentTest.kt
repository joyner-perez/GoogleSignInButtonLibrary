package com.joyner.googlesignincomposelibrary.ui.buttons.common

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for [CommonSignButtonContent] loading animation.
 *
 * Since [CommonSignButtonContent] is an internal composable, these tests verify that
 * the [androidx.compose.animation.Crossfade] animation correctly swaps between the
 * normal button content and the [androidx.compose.material3.CircularProgressIndicator].
 */
@RunWith(AndroidJUnit4::class)
class CommonSignButtonContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // region Not loading state

    @Test
    fun notLoading_displays_signInText() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = false) }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun notLoading_displays_google_icon() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = false) }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun notLoading_has_no_spinner() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = false) }
        composeTestRule.waitForIdle()
        composeTestRule
            .onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertDoesNotExist()
    }

    // endregion

    // region Loading state

    @Test
    fun loading_shows_circular_progress_indicator() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = true) }
        composeTestRule.waitForIdle()
        composeTestRule
            .onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertIsDisplayed()
    }

    @Test
    fun loading_hides_signInText() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = true) }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Sign in with Google").assertDoesNotExist()
    }

    @Test
    fun loading_hides_google_icon() {
        composeTestRule.setContent { CommonSignButtonContent(isLoading = true) }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithContentDescription("Google icon").assertDoesNotExist()
    }

    // endregion

    // region showIcon = false

    @Test
    fun notLoading_showIcon_false_hides_google_icon() {
        composeTestRule.setContent {
            CommonSignButtonContent(isLoading = false, showIcon = false)
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertDoesNotExist()
    }

    @Test
    fun notLoading_showIcon_false_still_shows_signInText() {
        composeTestRule.setContent {
            CommonSignButtonContent(isLoading = false, showIcon = false)
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    // endregion
}
