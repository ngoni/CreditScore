package com.scribblex.creditscore.ui.components

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test


class DonutTextComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_credit_score_text_is_visible() {
        composeTestRule.setContent {
            val modifier = Modifier.wrapContentSize()
            DonutTextComponent(modifier = modifier)
        }
        composeTestRule
            .onNodeWithText("Your credit score is")
            .assertExists()
    }
}