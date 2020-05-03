package com.example.higuuugithubapi.main

import com.example.higuuugithubapi.R
import com.example.higuuugithubapi.data.UserRepoResponse
import com.example.higuuugithubapi.databinding.ItemListBinding
import com.xwray.groupie.databinding.BindableItem

class ItemList(private val repo: UserRepoResponse) : BindableItem<ItemListBinding>() {
    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {
        viewBinding.name = repo.name
        viewBinding.id = repo.id
        viewBinding.htmlUrl = repo.html_url
    }
}