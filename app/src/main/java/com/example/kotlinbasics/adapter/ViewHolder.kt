package com.example.kotlinbasics.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbasics.InteractionInter
import com.example.kotlinbasics.databinding.ListItemBinding
import com.example.kotlinbasics.domain.StudentDomain

class ViewHolder(private val binding:ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(studentObj : StudentDomain, position : Int,interactionInter:InteractionInter){
        binding.tvName.text = studentObj.studentName
        binding.tvRollNo.text = studentObj.rollNum
        binding.root.setOnClickListener {
        interactionInter.showToast(position)
        }
        binding.root.setOnLongClickListener {
            interactionInter.delete(position)
            true

        }
    }
}