package com.example.sidedish.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sidedish.R
import com.example.sidedish.databinding.ActivityLoginBinding
import com.example.sidedish.databinding.FragmentLoginBinding
import com.example.sidedish.ui.viewmodel.MenuListViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.HttpUrl

class LoginFragment : Fragment() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btLogin.setOnClickListener {
            login()
        }
    }

    private fun loginOauth() {

    }
}