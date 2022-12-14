package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.Repository.MainRepository
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.Util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel
    @Inject constructor(private val mainRepository: MainRepository) :ViewModel() {

        private val _postStateFlow  :MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
        val postStateFlow  : StateFlow<ApiState> = _postStateFlow

        fun getPost() = viewModelScope.launch {
              _postStateFlow.value = ApiState.Loading
              mainRepository.getPost()
                  .catch { e ->
                      _postStateFlow.value =  ApiState.Failure(e)
                  }
                  .collect{ data ->
                        _postStateFlow.value = ApiState.Success(data)
                  }
        }
}