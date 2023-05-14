package com.shady_selim.simple_compose_app.ui.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.shady_selim.simple_compose_app.data.model.TrendingUser

@Composable
fun TrendingUserList(trendingUser: List<TrendingUser> = listOf(), isLoading: Boolean = false) {
    LazyColumn {
        if (isLoading) {
            items(10) {
                TrendingUserShimmerItem()
            }
        } else {
            items(trendingUser) { repository ->
                TrendingUserItem(repository)
            }
        }
    }
}