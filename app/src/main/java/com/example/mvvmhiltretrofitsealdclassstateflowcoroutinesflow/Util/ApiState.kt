package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.Util

import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.data.Post

sealed class ApiState{

    object Loading : ApiState()
    class  Failure(val msg:Throwable)    : ApiState()
    class  Success(val data:List<Post>)  : ApiState()
    object Empty : ApiState()

}
