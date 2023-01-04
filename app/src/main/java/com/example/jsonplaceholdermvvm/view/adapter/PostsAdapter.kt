package com.example.jsonplaceholdermvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.jsonplaceholdermvvm.databinding.RowItemBinding
import com.example.jsonplaceholdermvvm.model.dto.PostResponseItem

/**
 * Created by Aalishan Ansari on 04/01/23.
 */
class PostsAdapter(val adapterItemClick: (PostResponseItem) -> Unit) :
    RecyclerView.Adapter<PostsAdapter.PostHolder>() {

    var postList = ArrayList<PostResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bindItems(position)
    }

    override fun getItemCount() = postList.size

    inner class PostHolder(private val binding: RowItemBinding) : ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                adapterItemClick.invoke(postList[adapterPosition])
            }
        }

        fun bindItems(position: Int) {
            binding.tvPost.text = postList[position].title
        }

    }
}