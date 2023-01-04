package com.example.jsonplaceholdermvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholdermvvm.model.dto.PostResponse
import com.example.jsonplaceholdermvvm.model.repository.PostRepositoryImpl
import com.example.jsonplaceholdermvvm.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 02/01/23.
 */
@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepositoryImpl) : ViewModel() {

    private var _postsMutableLiveData = MutableLiveData<ApiResponse<PostResponse>>()
    val postsLiveData: LiveData<ApiResponse<PostResponse>> get() = _postsMutableLiveData

    fun getPost() {
        _postsMutableLiveData.value = (ApiResponse.Loading())
        viewModelScope.launch(Dispatchers.IO) {
            _postsMutableLiveData.postValue(repository.getPosts())
        }
    }
}