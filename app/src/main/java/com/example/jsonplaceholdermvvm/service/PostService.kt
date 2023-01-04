package com.example.jsonplaceholdermvvm.service

import com.example.jsonplaceholdermvvm.model.dto.PostResponse
import retrofit2.http.GET

/**
 * Created by Aalishan Ansari on 02/01/23.
 */
interface PostService {
    @GET("posts")
    suspend fun getPosts(): PostResponse
}