package com.example.retroexample.data

import androidx.lifecycle.MutableLiveData
import com.example.retroexample.network.QuotesApi
import com.example.retroexample.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository {
    companion object {
        fun getQuotes(): MutableLiveData<ArrayList<String>>? {
            val quotesMutableLiveData: MutableLiveData<ArrayList<String>> =
                MutableLiveData<ArrayList<String>>()
            CoroutineScope(Dispatchers.Default).launch {
                launch(Dispatchers.IO) {
                    val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
                    val response = quotesApi.getQuotes()
                    withContext(Dispatchers.Default)
                    {
                        response?.let {
                            if (response.isSuccessful) {
                                val quotesList = ArrayList<String>()
                                response.body()!!.results.forEach {
                                    quotesList.add(it.content)
                                }
                                quotesMutableLiveData.postValue(quotesList)
                            }
                        }
                    }
                }
            }
            return quotesMutableLiveData
        }
    }
}