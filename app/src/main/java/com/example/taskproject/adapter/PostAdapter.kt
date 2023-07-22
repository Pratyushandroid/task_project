package com.example.taskproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskproject.PostsItem
import com.example.taskproject.R

class PostAdapter(val postList:List<PostsItem>):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    var OnItemClick:(PostsItem) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = postList[position].title
        holder.id.text = postList[position].id.toString()

//        holder.itemView.setOnClickListener {
//            OnItemClick.invoke(postList[position])
//
//        }
        holder.title.setOnClickListener {
            OnItemClick.invoke(postList[position])
        }
    }


    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        val title = item.findViewById<TextView>(R.id.posttitle)
        val id = item.findViewById<TextView>(R.id.id)
    }
}