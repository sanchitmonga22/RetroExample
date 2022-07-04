package com.example.retroexample

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retroexample.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mViewModel: DummyDataVM
    private lateinit var mBinding: MainActivityBinding
    private val listItems = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this)[DummyDataVM::class.java]

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        mBinding.quotesListView.adapter = adapter
        val observer: Observer<List<String>> = Observer<List<String>> {
            updateList(it)
        }
        mViewModel.getQuotesRepository().observe(this, observer)
    }

    private fun updateList(loadedItems: List<String>) {
        listItems.clear()
        listItems.addAll(loadedItems)
        adapter.notifyDataSetChanged()
    }


//    override fun onResume() {
//        super.onResume()
//        var listItems: ArrayList<String>
//        mViewModel.getQuotesRepository().let {
//            listItems = mViewModel.getQuotesRepository().value!!
//        }
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
//    }
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