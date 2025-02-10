package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentInteractBinding

class InteractFrag : Fragment() {
    private lateinit var interactBinding: FragmentInteractBinding
    private lateinit var actFragInteraction: ActFragInteraction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actFragInteraction= activity as ActFragInteraction

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        interactBinding=FragmentInteractBinding.inflate(inflater,container,false)
        return interactBinding.root
    }
}