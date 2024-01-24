package com.example.myapp.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapp.model.User

class RegistrationViewModel : ViewModel() {

    val userLiveData = MutableLiveData<User>()
    val errorLiveData = MutableLiveData<String>()

    fun registerUser(user: User) {
        if (isUserDataValid(user)) {
            userLiveData.value = user
        } else {
            errorLiveData.value = "Invalid data. Please check the fields."
        }
    }

    private fun isUserDataValid(user: User): Boolean {
        // Implement your validation rules here
        return user.lastName.length >= 2 && user.password.matches(Regex(".*[0-9].*")) && user.password.matches(Regex(".*[A-Z].*"))
    }
}
