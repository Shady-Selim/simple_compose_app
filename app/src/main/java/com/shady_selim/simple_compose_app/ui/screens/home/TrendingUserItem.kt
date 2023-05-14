package com.shady_selim.simple_compose_app.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.shady_selim.simple_compose_app.R
import com.shady_selim.simple_compose_app.data.model.TrendingUser
import com.shady_selim.simple_compose_app.ui.theme.SimpleComposeAppTheme

@Composable
fun TrendingUserItem(trendingUser: TrendingUser) {
    Divider(color = Color.LightGray, thickness = 1.dp)
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = trendingUser.owner.imageURL,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .background(color = Color.LightGray)
                .height(46.dp)
                .width(46.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = trendingUser.owner.login,
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray
            )
            Text(text = trendingUser.name, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = trendingUser.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.DarkGray
            )
            Row {
                trendingUser.language?.let {
                    AsyncImage(
                        model = R.drawable.baseline_circle_24,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .height(14.dp)
                            .width(14.dp)
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                trendingUser.stars?.let {
                    AsyncImage(
                        model = R.drawable.baseline_grade_24,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .height(16.dp)
                            .width(16.dp)
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItem() {
    SimpleComposeAppTheme {
        TrendingUserItemPreview()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemDark() {
    SimpleComposeAppTheme(darkTheme = true) {
        TrendingUserItemPreview()
    }
}

@Composable
fun TrendingUserItemPreview(){
    TrendingUserItem(
        trendingUser = TrendingUser(
            owner = TrendingUser.User("user name", ""),
            name = "Repo name",
            description = "des des des des",
            language = "Kotlin",
            stars = "100"
        )
    )
}