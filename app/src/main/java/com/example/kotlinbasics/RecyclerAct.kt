package com.example.kotlinbasics

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinbasics.adapter.StudentAdapter
import com.example.kotlinbasics.databinding.ActivityRecyclerBinding
import com.example.kotlinbasics.databinding.CustomDialogBinding
import com.example.kotlinbasics.domain.StudentDomain

class RecyclerAct : AppCompatActivity() ,InteractionInter{
    private lateinit var binding:ActivityRecyclerBinding
    private lateinit var adapter:StudentAdapter
    val list=ArrayList<StudentDomain>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        list.add(StudentDomain("abc","1"))
        list.add(StudentDomain("sef","2"))
        list.add(StudentDomain("def","3"))
        list.add(StudentDomain("jkl","4"))
        list.add(StudentDomain("bnm","5"))
        list.add(StudentDomain("uio","6"))
        list.add(StudentDomain("fgh","7"))
        adapter=StudentAdapter(list, this)
        binding.recycler.adapter=adapter
        binding.recycler.layoutManager=LinearLayoutManager(this,)
    }

    override fun showToast(position: Int) {
       Toast.makeText(this,"You selected: ${list[position].studentName}",Toast.LENGTH_SHORT).show()
    }

    override fun delete(position: Int) {
        val dialog=Dialog(this)
        val dialogBinding=CustomDialogBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.show()
        dialog.window?.setBackgroundDrawable(AppCompatResources.getDrawable(this,R.drawable.custom_dialog_bg))
        dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialogBinding.btnDelete.setOnClickListener {
            list.removeAt(position)
            adapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        dialogBinding.imgCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

    }
}