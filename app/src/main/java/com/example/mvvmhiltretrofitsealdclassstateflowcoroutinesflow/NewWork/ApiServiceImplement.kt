package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork

import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork.ApiService
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.data.Post
import javax.inject.Inject
import javax.inject.Named

class ApiServiceImplement @Inject constructor(private val apiService: ApiService) {


    suspend fun getPost():List<Post> = apiService.getPost()

}