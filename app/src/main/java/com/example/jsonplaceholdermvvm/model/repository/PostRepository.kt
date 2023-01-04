package com.example.jsonplaceholdermvvm.model.repository

import com.example.jsonplaceholdermvvm.model.dto.PostResponse
import com.example.jsonplaceholdermvvm.utils.ApiResponse

/**
 * Created by Aalishan Ansari on 02/01/23.
 */
interface PostRepository {
    suspend fun getPosts(): ApiResponse<PostResponse>
}