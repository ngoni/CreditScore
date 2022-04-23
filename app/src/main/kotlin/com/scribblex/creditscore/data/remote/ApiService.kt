package com.scribblex.creditscore.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("endpoint.json")
    suspend fun getCreditReport()
}