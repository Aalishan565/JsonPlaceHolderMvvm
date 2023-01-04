package com.example.jsonplaceholdermvvm.utils

sealed class ApiResponse<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T? = null) : ApiResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : ApiResponse<T>(data, message)
    class Loading<T> : ApiResponse<T>()
}