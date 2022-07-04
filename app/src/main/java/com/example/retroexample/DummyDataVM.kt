package com.example.retroexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retroexample.data.Repository

class DummyDataVM : ViewModel() {
    private var quotesListLiveData = MutableLiveData<ArrayList<String>>()
    fun getQuotesRepository(): LiveData<ArrayList<String>> {
        return quotesListLiveData
    }

    init {
        quotesListLiveData = Repository.getQuotes()!!
    }
}