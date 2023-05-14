package com.shady_selim.simple_compose_app.ui.screens.home

import com.shady_selim.simple_compose_app.data.model.TrendingUser

sealed class TrendingUserState {
    object Loading : TrendingUserState()
    data class Success(val repositories: List<TrendingUser>) : TrendingUserState()
    data class Error(val message: String) : TrendingUserState()
}