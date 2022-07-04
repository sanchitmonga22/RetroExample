package com.example.retroexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retroexample.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mViewModel: DummyDataVM
    private lateinit var mBinding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this)[DummyDataVM::class.java]
    }

    override fun onResume() {
        super.onResume()
        mViewModel.getQuotesRepository().let { result ->
            result?.value?.get(0)?.content?.let { author ->
                Log.d("QUOOOOTEESSS", author)
            }
        }
    }
}

/**
 * {
"count": 20,
"totalCount": 1885,
"page": 1,
"totalPages": 95,
"lastItemIndex": 20,
"results": [
{
"tags": [
"famous-quotes",
"inspirational"
],
"_id": "QdK00IhCNX",
"author": "Larry Page",
"content": "If you're changing the world, you're working on important things. You're excited to get up in the morning.",
"authorSlug": "larry-page",
"length": 106,
"dateAdded": "2021-06-18",
"dateModified": "2021-06-18"
},
 */