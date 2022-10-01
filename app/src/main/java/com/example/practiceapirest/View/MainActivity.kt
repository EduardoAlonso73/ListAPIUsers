package com.example.practiceapirest.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practiceapirest.MainViewModel.MainViewModel
import com.example.practiceapirest.Model.User
import com.example.practiceapirest.R
import com.example.practiceapirest.databinding.ActivityMainBinding
import com.example.practiceapirestad.AdapterItem

class MainActivity : AppCompatActivity() {
    private lateinit var  mBinding: ActivityMainBinding
    private lateinit var  mGridLayout: GridLayoutManager
    private  lateinit  var mAdapter:AdapterItem
    //MainViewModel
    private  lateinit var  mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupViewModel()
        setupRecyclerView()
    }

    private fun setupViewModel() {
        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mMainViewModel.getAllUser().observe(this) {
            mAdapter.setListUser(it)
        }

    }

    private fun setupRecyclerView() {
        mAdapter= AdapterItem(mutableListOf())
        mGridLayout=GridLayoutManager(this,1)
        mBinding.recyclerView.apply{
            setHasFixedSize(true)
            layoutManager=mGridLayout
            adapter=mAdapter
        }

    }
}
