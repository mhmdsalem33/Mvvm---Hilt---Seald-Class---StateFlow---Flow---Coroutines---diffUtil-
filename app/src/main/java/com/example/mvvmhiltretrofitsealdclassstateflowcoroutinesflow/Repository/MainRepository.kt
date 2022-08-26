package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.Repository

import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork.ApiService
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.NewWork.ApiServiceImplement
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.data.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepository @Inject  constructor(private val apiServiceImp : ApiServiceImplement) {

    fun getPost(): Flow<List<Post>> = flow {
        emit(apiServiceImp.getPost())
    }.flowOn(Dispatchers.IO)
}