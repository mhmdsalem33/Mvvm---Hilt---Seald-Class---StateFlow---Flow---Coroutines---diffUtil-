package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.Util.ApiState
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.ViewModels.MainViewModel
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.adapter.PostAdapter
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var postAdapter: PostAdapter

    private val mainMvvm : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        postAdapter = PostAdapter()
        preparePostRecyclerView()

        mainMvvm.getPost()
        getApiData()

    }

    private fun getApiData() {
        lifecycleScope.launchWhenCreated {
            mainMvvm.postStateFlow.collect{ data ->
                when(data){
                    is ApiState.Loading -> {
                        Log.d("testApp" , "Loading")
                    }
                    is ApiState.Failure -> {
                        Log.d("testApp" , "Falied")
                    }
                    is  ApiState.Success -> {
                        postAdapter.differ.submitList(data.data)
                        Log.d("testApp" , "success")
                    }
                    is ApiState.Empty ->{

                    }
                }

            }
        }
    }

    private fun preparePostRecyclerView() {
        binding.postRec.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postAdapter

        }
    }

}