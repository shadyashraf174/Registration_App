package com.example.myapp.presentation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.R
import com.example.myapp.databinding.FragmentRegistrationBinding
import com.example.myapp.model.User
import com.example.myapp.presentation.home.HomeFragment

class RegistrationFragment : Fragment() {

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        binding.registrationButton.setOnClickListener {
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val dateOfBirth = binding.dateOfBirthEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val user = User(firstName, lastName, dateOfBirth, password)
            viewModel.registerUser(user)
        }

        // Observe errors
        viewModel.errorLiveData.observe(viewLifecycleOwner) { errorMessage ->
            // Handle error messages here
            // For simplicity, you can toast the error message
            showToast(errorMessage)
        }

        // Observe successful registration
        viewModel.userLiveData.observe(viewLifecycleOwner) { user ->
            // Navigate to Home Screen or perform required action
            // For simplicity, let's pass the user data to the HomeFragment
            navigateToHomeFragment(user)
        }

        return binding.root
    }

    private fun showToast(message: String) {
        // Implement toast notification
    }

    private fun navigateToHomeFragment(user: User) {
        val homeFragment = HomeFragment()
        val bundle = Bundle()
        bundle.putString("userName", "${user.firstName} ${user.lastName}")
        homeFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .addToBackStack(null)
            .commit()
    }
}
