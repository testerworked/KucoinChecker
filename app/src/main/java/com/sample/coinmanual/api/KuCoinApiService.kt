package com.sample.coinmanual.api


import retrofit2.http.Body
import retrofit2.http.POST

interface KuCoinApiService {
    @POST("api/v1/auth")
    suspend fun authenticate(@Body body: AuthRequest): AuthResponse
}

data class AuthRequest(
    val api_key: String,
    val api_secret: String,
    val api_passphrase: String
)

data class AuthResponse(
    val code: String,
    val data: String? // Adjust based on actual response structure
)