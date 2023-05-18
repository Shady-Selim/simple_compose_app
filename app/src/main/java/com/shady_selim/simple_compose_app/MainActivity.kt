package com.shady_selim.simple_compose_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.shady_selim.simple_compose_app.ui.screens.generic.LoadingWithError
import com.shady_selim.simple_compose_app.ui.screens.home.TrendingUserList
import com.shady_selim.simple_compose_app.ui.screens.home.TrendingUserState
import com.shady_selim.simple_compose_app.ui.screens.home.TrendingUserViewModel
import com.shady_selim.simple_compose_app.ui.theme.SimpleComposeAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: TrendingUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = viewModel.state.collectAsState()
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row {
                            Text(
                                text = stringResource(R.string.trending),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier.weight(1.0f)
                            )
                            AsyncImage(
                                model = R.drawable.baseline_menu_24,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .padding(top = 8.dp, end = 16.dp)
                                    .height(32.dp)
                                    .width(3.dp)
                            )
                        }

                        Row {
                            Spacer(modifier = Modifier.width(24.dp))
                            TrendingUserScreen(state.value)
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun TrendingUserScreen(state: TrendingUserState) {
    when (state) {
        TrendingUserState.Loading -> {
            TrendingUserList(isLoading = true)
        }

        is TrendingUserState.Success -> {
            TrendingUserList(state.repositories)
        }

        is TrendingUserState.Error -> {
            //Text(text = "Error: ${state.message}")
            LoadingWithError()
        }
    }
}




