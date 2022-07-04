package com.example.retroexample

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
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
        mViewModel.getQuotesRepository().observe(this) {
            updateList(it)
        }
        mBinding.quotesListView.adapter = adapter
    }

    private fun updateList(loadedItems: List<String>) {
        listItems.clear()
        listItems.addAll(loadedItems)
        adapter.notifyDataSetChanged()
    }
}