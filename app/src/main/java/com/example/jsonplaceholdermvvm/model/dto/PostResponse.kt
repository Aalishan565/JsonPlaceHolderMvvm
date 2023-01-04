package com.example.jsonplaceholdermvvm.model.dto

import com.google.gson.annotations.SerializedName

class PostResponse : ArrayList<PostResponseItem>()

data class PostResponseItem(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)