package com.scribblex.creditscore.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.scribblex.creditscore.ui.theme.getColor
import com.scribblex.creditscore.utils.Margins.DP_300


@Composable
fun DonutComponent(
    proportion: Float,
    score: String,
    maxScore: String
) {

    ConstraintLayout(
        modifier = Modifier
            // todo: maybe change to wrapContentSize()
            .fillMaxSize()
    ) {

        val (outerCircle, animatedCircle, scoreText) = createRefs()

        // Outer Circle
        val outerCircleModifier = Modifier.constrainAs(outerCircle) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        DrawCircle(outerCircleModifier)

        // Animated Circle
        val proportions = listOf(proportion)
        val circleColors = listOf(getColor().primaryVariant)
        val animatedCircleModifier = Modifier
            .height(DP_300)
            .fillMaxSize()
            .constrainAs(animatedCircle) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        AnimatedCircle(
            proportions,
            circleColors,
            animatedCircleModifier
        )

        // Score Text
        val modifier = Modifier.constrainAs(scoreText) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        DonutTextComponent(
            modifier = modifier,
            score = score,
            maxScore = maxScore
        )
    }

}

@Composable
private fun DrawCircle(modifier: Modifier) {
    Canvas(
        modifier = modifier.size(310.dp),
        onDraw = {
            drawArc(
                color = Color.Black,
                0f,
                360f,
                false,
                style = Stroke(3f, cap = StrokeCap.Butt)
            )
        }
    )
}