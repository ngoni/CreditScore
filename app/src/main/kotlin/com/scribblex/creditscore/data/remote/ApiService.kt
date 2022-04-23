package com.scribblex.creditscore.data.remote

import com.scribblex.creditscore.data.entities.CreditReport
import retrofit2.http.GET

interface ApiService {
    @GET("endpoint.json")
    suspend fun getCreditReport() : CreditReport
}