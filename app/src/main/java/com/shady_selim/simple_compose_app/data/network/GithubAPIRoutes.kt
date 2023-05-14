package com.shady_selim.simple_compose_app.data.network

object GithubAPIRoutes {
    private const val BASE_URL = "https://api.github.com"
    const val PRODUCTS = "$BASE_URL/search/repositories?q=language=+sort:stars"
}