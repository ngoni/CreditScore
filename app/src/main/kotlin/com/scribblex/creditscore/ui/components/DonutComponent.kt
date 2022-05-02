package com.scribblex.creditscore.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import com.scribblex.creditscore.utils.Margins.DP_300

private val LightOrange = Color(0xFFFF8C66)

@Composable
fun DonutComponent(proportion: Float) {
    ConstraintLayout(
        modifier = Modifier
            // todo: maybe change to wrapContentSize()
            .fillMaxSize()
    ) {
        val (animatedCircle, scoreText) = createRefs()

        // Animated Circle
        val proportions = listOf(proportion)
        val circleColors = listOf(LightOrange)

        AnimatedCircle(
            proportions,
            circleColors,
            Modifier
                .height(DP_300)
                .fillMaxSize()
                .constrainAs(animatedCircle) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        // Score Text
        val modifier = Modifier.constrainAs(scoreText) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        DonutTextComponent(modifier = modifier)
    }

}