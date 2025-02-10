package com.example.kotlinbasics.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentFragEmailIntentBinding


class FragEmailIntent : Fragment() {
        private lateinit var fragEmailIntentBinding: FragmentFragEmailIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragEmailIntentBinding=FragmentFragEmailIntentBinding.inflate(inflater,container,false)
        return fragEmailIntentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragEmailIntentBinding.et1.doOnTextChanged { text, _, _, _ ->
            if(text?.length == 1){
                fragEmailIntentBinding.et2.requestFocus()
            }
        }
    }

}