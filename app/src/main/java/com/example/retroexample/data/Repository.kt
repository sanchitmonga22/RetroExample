package com.example.retroexample.data

import androidx.lifecycle.MutableLiveData
import com.example.retroexample.model.Result
import com.example.retroexample.network.QuotesApi
import com.example.retroexample.network.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Repository {
    companion object {
        fun getCustomers(): MutableLiveData<ArrayList<Result>>? {
            val quotesMutableLiveData: MutableLiveData<ArrayList<Result>> =
                MutableLiveData<ArrayList<Result>>()
            CoroutineScope(Dispatchers.Default).launch {
                launch(Dispatchers.IO) {
                    val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
                    val response = quotesApi.getQuotes()
                    withContext(Dispatchers.Default)
                    {
                        response?.let {
                            if (response.isSuccessful) {
                                quotesMutableLiveData.postValue(response.body()!!.results)
                            }
                        }
                    }
                }
            }
            return quotesMutableLiveData
        }
    }
}