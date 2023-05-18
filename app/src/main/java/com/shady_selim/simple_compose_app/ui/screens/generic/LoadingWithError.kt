package com.shady_selim.simple_compose_app.ui.screens.generic

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.shady_selim.simple_compose_app.R

@Composable
fun LoadingWithError() {
    Row {
        Spacer(modifier = Modifier.width(32.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.retry_and_user_busy_version_2))
            LottieAnimation(composition)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.something_went_wrong),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(R.string.an_alien_is_probably_blocking_your_signal),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedButton(
                onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, Color.Green),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green),
                shape = RoundedCornerShape(15)
            ) {
                Text(text = stringResource(R.string.retry))
            }
        }
    }

}