package com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.data.Post
import com.example.mvvmhiltretrofitsealdclassstateflowcoroutinesflow.databinding.PostrowBinding


class PostAdapter():RecyclerView.Adapter<PostAdapter.ViewHolder>() {

   private val diffUtil = object :DiffUtil.ItemCallback<Post>(){
       override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
           return oldItem.body == newItem.body
       }

       override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
             return oldItem == newItem
       }
   }

    val differ = AsyncListDiffer(this , diffUtil)

    class ViewHolder(val binding : PostrowBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return  ViewHolder(PostrowBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val data = differ.currentList[position]
         holder.binding.tasks.text = data.body
    }
    override fun getItemCount() = differ.currentList.size
}