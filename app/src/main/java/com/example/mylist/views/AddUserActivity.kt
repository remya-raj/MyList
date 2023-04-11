package com.example.mylist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mylist.R
import com.example.mylist.databinding.ActivityAddUserBinding
import com.example.mylist.model.User
import com.example.mylist.viewmodels.MainViewModel

class AddUserActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddUserBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()
    }

    private fun initData() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initView() {
        binding.btnAdd.setOnClickListener {
            viewModel.addUser(User(0,binding.etUserName.text.toString(), binding.etAge.text.toString(), binding.etEmail.text.toString()))
        }
    }
}