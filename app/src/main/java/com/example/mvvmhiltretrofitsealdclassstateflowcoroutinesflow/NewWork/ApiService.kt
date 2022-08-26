package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork

import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.data.Post
import retrofit2.http.GET

interface ApiService {


    @GET("posts")
    suspend fun getPost()  :List<Post>

}