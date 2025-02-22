package com.example.kotlinbasics.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.InteractionInter
import com.example.kotlinbasics.databinding.ListItemBinding
import com.example.kotlinbasics.domain.StudentDomain

class StudentAdapter(private val list: ArrayList<StudentDomain>,private val interactionInter: InteractionInter):RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position],position,interactionInter)
    }
}