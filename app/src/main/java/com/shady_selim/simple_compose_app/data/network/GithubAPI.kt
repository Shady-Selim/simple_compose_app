package com.shady_selim.simple_compose_app.data.network

import com.shady_selim.simple_compose_app.data.model.TrendingUser
import com.shady_selim.simple_compose_app.data.network.GithubAPIRoutes.PRODUCTS
import com.shady_selim.simple_compose_app.data.network.GithubService.client
import io.ktor.client.request.get

class GithubAPI {
    suspend fun parseTrendingUsersJson(): List<TrendingUser> = GithubService.parseTrendingUsersJson(client.get<String>(PRODUCTS))
}