package com.example.myapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

       binding.welcomeButtonn.setOnClickListener {
            // Show modal window with user greeting and entered name
            // For simplicity, just print a message
            println("Welcome ${arguments?.getString("userName")}")
        }

        return binding.root
    }
}
