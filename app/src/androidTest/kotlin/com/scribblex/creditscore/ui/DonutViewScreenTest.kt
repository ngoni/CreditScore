package com.scribblex.creditscore.ui

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.scribblex.creditscore.ui.components.DonutComponent
import org.junit.Rule
import org.junit.Test

class DonutViewScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_email_reports_text_is_visible() {
        composeTestRule.setContent {
            DonutViewScreen()
        }
        composeTestRule
            .onNodeWithText("Email reports")
            .assertExists()
    }

    @Test
    fun check_call_to_action_button_is_enabled() {
        composeTestRule.setContent {
            DonutViewScreen()
        }
        composeTestRule
            .onNodeWithText("Start my trial")
            .assertIsEnabled()
    }
}