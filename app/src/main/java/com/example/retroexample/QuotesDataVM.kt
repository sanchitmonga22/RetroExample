package com.example.retroexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retroexample.data.Repository

/**
 * ViewModel for Quotes
 */
class QuotesDataVM : ViewModel() {
    private var quotesListLiveData = MutableLiveData<ArrayList<String>>()

    // To get the list of quotes.
    fun getQuotesRepository(): LiveData<ArrayList<String>> {
        return quotesListLiveData
    }

    init {
        quotesListLiveData = Repository.getQuotes()
    }
}