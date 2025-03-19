package com.josh.compose.components

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.josh25.uitestsjetpackcompose.ui.JoshComponent
import org.junit.Rule
import org.junit.Test

class ComposeComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // Common Compose Test syntax
    @Test
    fun whenTextFieldUpdates_thenVerifyTextChanges2() {
        composeTestRule.setContent {
                JoshComponent()
        }

        // Wait for UI to be fully loaded
        composeTestRule.waitForIdle()
        // Thread.sleep(500) // last resort for slow tests

        // Assertions
        composeTestRule.onAllNodesWithText("josh", ignoreCase = true, substring = true).assertCountEquals(4)
        composeTestRule.onAllNodesWithText("JOSH")
        composeTestRule.onNodeWithTag("component1").assertExists()
        composeTestRule.onNodeWithTag("component2").assertExists()
        composeTestRule.onNodeWithTag("component9999").assertDoesNotExist()
        composeTestRule.onNodeWithTag("button").assertExists()
        composeTestRule.onNodeWithText("llamas", substring = true).assertExists()
        composeTestRule.onNodeWithText("te llamas josh", substring = true, ignoreCase = true).assertExists()
        composeTestRule.onNodeWithContentDescription("superImage").assertIsDisplayed()

        /* Other components
        composeTestRule.onNodeWithTag("checkbox").assertIsSelected()
        composeTestRule.onNodeWithTag("textfield").assertIsFocused()
         */

        // Input new name
        composeTestRule.onNodeWithTag("button").performClick()
        composeTestRule.onNodeWithTag("textfield").performTextInput("Josh")
        composeTestRule.onNodeWithTag("textfield").performTextClearance()
        composeTestRule.onNodeWithTag("textfield").performTextInput("Josh")
        composeTestRule.onNodeWithText("Te llamas josh", ignoreCase = true, substring = true).assertExists()
        composeTestRule.onNodeWithTag("tellamas").assertTextEquals("Te llamas Josh")
    }
}