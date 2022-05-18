package com.jorgewilli.comvidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.service.model.PostModel
import com.jorgewilli.comvidados.view.viewholder.PostViewHolder

class PostAdapter: RecyclerView.Adapter<PostViewHolder>() {
    private var mPostList: List<PostModel> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_post, parent, false)
        return PostViewHolder(item)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(mPostList[position])
    }

    override fun getItemCount(): Int {
        return mPostList.count()
    }


    fun updatePost(list: List<PostModel>){
        mPostList = list
        notifyDataSetChanged()
    }

    /*fun attachListener(listener: GuestListener){
        mListener = listener
    }*/
}