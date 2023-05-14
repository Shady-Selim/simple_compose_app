package com.shady_selim.simple_compose_app.data.repo

import com.shady_selim.simple_compose_app.data.model.TrendingUser
import com.shady_selim.simple_compose_app.data.network.GithubAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MainRepo {
    private val githubAPI: GithubAPI = GithubAPI()
    suspend fun parseTrendingUsersJson(): List<TrendingUser> = withContext(Dispatchers.IO){
        githubAPI.parseTrendingUsersJson()
    }
}