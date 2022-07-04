package com.example.retroexample.network

import com.example.retroexample.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

/**
 * Required by the retrofit
 */
interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>
}
