package com.davidson.phonebook.showContact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davidson.phonebook.ContactDAO

class ShowContactViewModelFactory(private val dao: ContactDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowContactViewModel::class.java)) {
            return ShowContactViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}