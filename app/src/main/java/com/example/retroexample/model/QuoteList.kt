package com.example.retroexample.model

/**
 * Data class to store the Quote list JSON object received from network
 */
data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: ArrayList<Result>,
    val totalCount: Int,
    val totalPages: Int
)
