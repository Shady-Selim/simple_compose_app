package com.shady_selim.simple_compose_app.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady_selim.simple_compose_app.data.repo.MainRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TrendingUserViewModel : ViewModel() {

    private val _state = MutableStateFlow<TrendingUserState>(TrendingUserState.Loading)
    val state: StateFlow<TrendingUserState> = _state

    init {
        fetchTrendingUsers()
    }

    private fun fetchTrendingUsers() {
        viewModelScope.launch {
            _state.emit(TrendingUserState.Loading)
            try {
                val repositories = MainRepo.parseTrendingUsersJson()
                _state.emit(TrendingUserState.Success(repositories))
            } catch (e: Exception) {
                _state.emit(TrendingUserState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}