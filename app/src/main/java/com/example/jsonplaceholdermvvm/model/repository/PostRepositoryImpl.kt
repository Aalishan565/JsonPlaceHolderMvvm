package com.example.jsonplaceholdermvvm.model.repository

import android.util.Log
import com.example.jsonplaceholdermvvm.service.PostService
import com.example.jsonplaceholdermvvm.model.dto.PostResponse
import com.example.jsonplaceholdermvvm.utils.ApiResponse
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 02/01/23.
 */
class PostRepositoryImpl @Inject constructor(private val postService: PostService) :
    PostRepository {

    override suspend fun getPosts(): ApiResponse<PostResponse> {
        return try {
            Log.d("PostRepositoryImpl", "success ${postService.getPosts().size}")
            ApiResponse.Success(postService.getPosts())
        } catch (e: Exception) {
            Log.d("PostRepositoryImpl", "Error ${e.message!!}")
            ApiResponse.Error(e.message!!)
        }
    }

}