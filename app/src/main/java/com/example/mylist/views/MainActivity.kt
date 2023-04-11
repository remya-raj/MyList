package com.example.mylist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mylist.databinding.ActivityMainBinding
import com.example.mylist.model.Database
import com.example.mylist.model.DatabaseBuilder
import com.example.mylist.model.User
import com.example.mylist.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
    }

    private fun initData() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.initDb(this)
    }

    fun initView() {
        viewModel.list.observe(this, Observer {
            binding.rvList.text = it.toString()
        })
        viewModel.getUserList()
    }
}