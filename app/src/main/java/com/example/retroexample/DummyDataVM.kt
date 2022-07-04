package com.example.retroexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DummyDataVM : ViewModel() {
    private var quotesListLiveData = MutableLiveData<ArrayList<Result>>()
    fun getQuotesRepository(): LiveData<ArrayList<Result>>? {
        return quotesListLiveData
    }

    init {
        quotesListLiveData = Repository.getCustomers()!!
    }
}