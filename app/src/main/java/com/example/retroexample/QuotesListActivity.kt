package com.example.retroexample

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retroexample.databinding.QuotesActivityBinding

class QuotesListActivity : AppCompatActivity() {

    private lateinit var mViewModel: QuotesDataVM
    private lateinit var mBinding: QuotesActivityBinding
    private val listItems = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding and inflating the view
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // binding the view model
        mViewModel = ViewModelProvider(this)[QuotesDataVM::class.java]

        // configuring the adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        mBinding.quotesListView.adapter = adapter

        // observing the live data that is being fetched.
        mViewModel.getQuotesRepository().observe(this) {
            updateList(it)
        }
    }

    private fun updateList(loadedItems: List<String>) {
        listItems.clear()
        listItems.addAll(loadedItems) // adding the new value of the list items
        adapter.notifyDataSetChanged()
    }
}