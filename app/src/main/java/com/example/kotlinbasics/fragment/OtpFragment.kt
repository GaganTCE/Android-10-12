package com.example.kotlinbasics.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinbasics.R
import com.example.kotlinbasics.databinding.FragmentOtpBinding
import kotlin.random.Random

class OtpFragment : Fragment() {
    private lateinit var fragmentOtpBinding: FragmentOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentOtpBinding=FragmentOtpBinding.inflate(inflater,container,false)
        return fragmentOtpBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    fragmentOtpBinding.btnOtp.setOnClickListener {
        val randomNum= Random.nextInt(1010,9999)
        val emailIntent=Intent().apply {
            action=Intent.ACTION_SENDTO
            data= Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL,"")
            putExtra(Intent.EXTRA_SUBJECT,"")
            putExtra(Intent.EXTRA_TEXT,"Your OTP for verification is: \n$randomNum")
        }
        startActivity(emailIntent)
        findNavController().navigate(R.id.action_otpFragment_to_fragEmailIntent)
    }
    }
}
