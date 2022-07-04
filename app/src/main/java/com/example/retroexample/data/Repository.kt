package com.example.retroexample.data

import androidx.lifecycle.MutableLiveData
import com.example.retroexample.network.QuotesApi
import com.example.retroexample.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Singleton class with reference to methods to get the data
 */
object Repository {

    fun getQuotes(): MutableLiveData<ArrayList<String>> {
        val quotesMutableLiveData: MutableLiveData<ArrayList<String>> =
            MutableLiveData<ArrayList<String>>()
        // launching a background task
        CoroutineScope(Dispatchers.Default).launch(Dispatchers.IO) {
            // making the network call using retrofit
            val response =
                RetrofitHelper.getInstance().create(QuotesApi::class.java).getQuotes()
            response.let {
                if (response.isSuccessful) {
                    val quotesList = ArrayList<String>()
                    response.body()!!.results.forEach {
                        quotesList.add(it.content)
                    }
                    quotesMutableLiveData.postValue(quotesList)
                }
            }
        }
        return quotesMutableLiveData
    }
}