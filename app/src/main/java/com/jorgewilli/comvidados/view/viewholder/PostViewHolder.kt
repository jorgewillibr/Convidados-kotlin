package com.jorgewilli.comvidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jorgewilli.comvidados.R
import com.jorgewilli.comvidados.service.model.PostModel

class PostViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    fun bind(post: PostModel) {
        val textTitle = itemView.findViewById<TextView>(R.id.text_title)
        textTitle.text = post.title

        val textBody = itemView.findViewById<TextView>(R.id.text_body)
        textBody.text = post.body
    }
}