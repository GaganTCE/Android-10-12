package com.example.kotlinbasics.fragment

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentFragEmailIntentBinding


class FragEmailIntent : Fragment() {
    private lateinit var fragEmailIntentBinding: FragmentFragEmailIntentBinding
    private lateinit var otpGen : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragEmailIntentBinding=FragmentFragEmailIntentBinding.inflate(inflater,container,false)
        return fragEmailIntentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        otpGen = bundle?.getString("otp").toString()
        val allEts = arrayOf(fragEmailIntentBinding.et1,fragEmailIntentBinding.et2,fragEmailIntentBinding.et3,fragEmailIntentBinding.et4)
        allEts.onEachIndexed { index, editText ->
            editText.doOnTextChanged { text, _, _, _ ->
                if(text?.length == 1) {
                    if (allEts[3] != editText) {
                        allEts[index + 1].requestFocus()
                    } else {
                        editText.clearFocus()
                        fragEmailIntentBinding.btnCheck.performClick()
                    }
                }
            }

            editText.setOnKeyListener { _, keyCode, keyEvent ->
                if(keyCode == KeyEvent.KEYCODE_DEL && keyEvent.action == KeyEvent.ACTION_DOWN){
                    if(editText.text.isEmpty()){
                        if(editText != allEts[0])
                        allEts[index - 1].requestFocus()
                    }
                }
                false
            }

        }

        fragEmailIntentBinding.btnCheck.setOnClickListener {
            var strEntered = ""
            for(i in allEts){
                strEntered += i.text.toString()
            }
            if(otpGen == strEntered){
                Toast.makeText(requireActivity(),"Otp Verified",Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(requireActivity(),"Otp Not Verified",Toast.LENGTH_SHORT).show()
            }
        }

    }

}