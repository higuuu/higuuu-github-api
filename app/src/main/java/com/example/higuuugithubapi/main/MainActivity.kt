package com.example.higuuugithubapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.higuuugithubapi.R
import com.example.higuuugithubapi.databinding.ActivityMainBinding
import com.example.higuuugithubapi.util.MainViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private val mainViewModel: MainViewModel by viewModels { mainViewModelFactory }

    fun sendUser(userName: String) {
        mainViewModel.getUser(userName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )

        binding.send.setOnClickListener {
            sendUser(binding.userName.text.toString())
        }

        mainViewModel.userRepos.observe(this, Observer {
            val items = it
            val groupAdapter = GroupAdapter<ViewHolder>()
            binding.recyclerView.adapter = groupAdapter

            val layoutManager = LinearLayoutManager(this)
            binding.recyclerView.setLayoutManager(layoutManager)

            items.forEach { item ->
                groupAdapter.add(ItemList(item))
            }
        })
    }
}
