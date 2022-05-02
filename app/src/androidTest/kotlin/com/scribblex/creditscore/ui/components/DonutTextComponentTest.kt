package com.scribblex.creditscore.ui.components

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class DonutTextComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_email_reports_text_is_visible() {
        composeTestRule.setContent {
            DonutTextComponent()
        }
        composeTestRule
            .onNodeWithText("Email reports")
            .assertExists()
    }

    @Test
    fun check_call_to_action_button_is_enabled() {
        composeTestRule.setContent {
            DonutTextComponent()
        }
        composeTestRule
            .onNodeWithText("Start my trial")
            .assertIsEnabled()
    }
}