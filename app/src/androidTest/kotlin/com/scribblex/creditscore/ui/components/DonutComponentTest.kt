package com.scribblex.creditscore.ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class DonutComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_donut_component_is_visible() {
        composeTestRule.setContent {
            DonutComponent(
                proportion = 0.7f,
                score = "200",
                maxScore = "700"
            )
        }
        composeTestRule
            .onNodeWithText("out of 700")
            .assertExists()
    }
}