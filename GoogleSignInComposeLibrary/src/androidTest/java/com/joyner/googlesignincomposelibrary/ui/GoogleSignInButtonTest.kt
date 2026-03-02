package com.joyner.googlesignincomposelibrary.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
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
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GoogleSignInButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // region Common button types — text visible

    @Test
    fun elevated_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun filled_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = Filled()) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun filledTonal_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = FilledTonal()) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun outlined_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = Outlined()) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun text_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = Text()) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    // endregion

    // region Click behavior

    @Test
    fun elevated_button_calls_onClick_when_clicked() {
        var clicked = false
        composeTestRule.setContent {
            GoogleSignInButton(onClick = { clicked = true })
        }
        composeTestRule.onNodeWithText("Sign in with Google").performClick()
        assertTrue(clicked)
    }

    @Test
    fun elevated_button_disabled_is_not_enabled() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, enabled = false)
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsNotEnabled()
    }

    @Test
    fun filled_button_disabled_is_not_enabled() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = Filled(), enabled = false)
        }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsNotEnabled()
    }

    // endregion

    // region Icon visibility

    @Test
    fun elevated_button_shows_google_icon_by_default() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun elevated_button_hides_google_icon_when_showIcon_false() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, showIcon = false) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertDoesNotExist()
    }

    @Test
    fun extendedFab_button_hides_google_icon_when_showIcon_false() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = FabExtended(), showIcon = false)
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertDoesNotExist()
    }

    // endregion

    // region FAB button types

    @Test
    fun fab_button_displays_google_icon() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = Fab()) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun smallFab_button_displays_google_icon() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = SmallFab()) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun largeFab_button_displays_google_icon() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = LargeFab()) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun extendedFab_button_displays_signInText() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = FabExtended()) }
        composeTestRule.onNodeWithText("Sign in with Google").assertIsDisplayed()
    }

    @Test
    fun fab_button_calls_onClick_when_clicked() {
        var clicked = false
        composeTestRule.setContent {
            GoogleSignInButton(onClick = { clicked = true }, buttonType = Fab())
        }
        composeTestRule.onNodeWithContentDescription("Google icon").performClick()
        assertTrue(clicked)
    }

    // endregion

    // region Icon button types

    @Test
    fun iconFilled_button_displays_google_icon() {
        composeTestRule.setContent { GoogleSignInButton(onClick = {}, buttonType = IconFilled()) }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun iconFilledTonal_button_displays_google_icon() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = IconFilledTonal())
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun iconOutlined_button_displays_google_icon() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = IconOutlined())
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun iconStandard_button_displays_google_icon() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = IconStandard())
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsDisplayed()
    }

    @Test
    fun iconFilled_button_disabled_is_not_enabled() {
        composeTestRule.setContent {
            GoogleSignInButton(onClick = {}, buttonType = IconFilled(), enabled = false)
        }
        composeTestRule.onNodeWithContentDescription("Google icon").assertIsNotEnabled()
    }

    @Test
    fun iconFilled_button_calls_onClick_when_clicked() {
        var clicked = false
        composeTestRule.setContent {
            GoogleSignInButton(onClick = { clicked = true }, buttonType = IconFilled())
        }
        composeTestRule.onNodeWithContentDescription("Google icon").performClick()
        assertTrue(clicked)
    }

    // endregion

    // region assertFalse usage

    @Test
    fun elevated_button_does_not_call_onClick_before_interaction() {
        var clicked = false
        composeTestRule.setContent {
            GoogleSignInButton(onClick = { clicked = true })
        }
        assertFalse(clicked)
    }

    // endregion
}
