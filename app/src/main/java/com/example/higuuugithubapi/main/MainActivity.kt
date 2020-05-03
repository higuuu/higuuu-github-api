package com.example.higuuugithubapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.higuuugithubapi.R
import com.example.higuuugithubapi.databinding.ActivityMainBinding
import com.example.higuuugithubapi.util.MainViewModelFactory
import com.example.higuuugithubapi.util.RepositoryFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main
            )

        val factory = MainViewModelFactory(RepositoryFactory.createClientApiRepository())

        mainViewModel = ViewModelProvider(
            this,
            factory
        ).get(MainViewModel::class.java)

        mainViewModel.getUser("higuuu")

        mainViewModel.userRepos.observe(this, Observer {
            binding.mainText.text = it.toString()
        })
    }
}
