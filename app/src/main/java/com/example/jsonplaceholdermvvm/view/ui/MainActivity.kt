package com.example.jsonplaceholdermvvm.view.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jsonplaceholdermvvm.databinding.ActivityMainBinding
import com.example.jsonplaceholdermvvm.model.dto.PostResponseItem
import com.example.jsonplaceholdermvvm.utils.ApiResponse
import com.example.jsonplaceholdermvvm.view.adapter.PostsAdapter
import com.example.jsonplaceholdermvvm.view_model.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private var _activityMainBinding: ActivityMainBinding? = null
    private val activityMainBinding get() = _activityMainBinding!!
    private lateinit var postsAdapter: PostsAdapter

    private val adapterItemClick: (PostResponseItem) -> Unit = {
        Log.d("Item clicked", "${it.title}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_activityMainBinding!!.root)
        postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel.getPost()
        initObserver()
    }

    private fun initObserver() {
        postViewModel.postsLiveData.observe(this) {
            when (it) {
                is ApiResponse.Loading -> {
                    activityMainBinding.progressBar.visibility = View.VISIBLE
                }
                is ApiResponse.Success -> {
                    activityMainBinding.progressBar.visibility = View.GONE
                    postsAdapter = PostsAdapter(adapterItemClick)
                    postsAdapter.postList = it.data as ArrayList<PostResponseItem>
                    activityMainBinding.rvPost.adapter = postsAdapter
                }
                is ApiResponse.Error -> {
                    activityMainBinding.progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}