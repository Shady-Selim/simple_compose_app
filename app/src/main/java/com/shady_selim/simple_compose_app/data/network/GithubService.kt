package com.shady_selim.simple_compose_app.data.network

import com.shady_selim.simple_compose_app.data.model.TrendingUser
import com.shady_selim.simple_compose_app.data.model.TrendingUserListResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

object GithubService {
    val client = HttpClient(Android)
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()



    fun parseTrendingUsersJson(json: String): List<TrendingUser> {
        val adapter: JsonAdapter<TrendingUserListResponse> =
            moshi.adapter(TrendingUserListResponse::class.java)
        val response: TrendingUserListResponse? = adapter.fromJson(json)
        return response?.items ?: emptyList()
    }
}