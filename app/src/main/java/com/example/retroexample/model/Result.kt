package com.example.retroexample.model

/**
 * Data class to store the result object of the quotes list received from the network
 */
data class Result(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)