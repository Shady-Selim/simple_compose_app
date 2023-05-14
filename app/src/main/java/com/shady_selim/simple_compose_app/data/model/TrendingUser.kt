package com.shady_selim.simple_compose_app.data.model

import com.squareup.moshi.Json

data class TrendingUser(
    val owner: User,
    val name: String,
    val description: String = "",
    val language: String? = "",
    @Json(name = "stargazers_count")
    val stars: String? = ""
) {
    data class User(
        val login: String,
        @Json(name = "avatar_url")
        val imageURL: String
    )
}