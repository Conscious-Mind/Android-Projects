package com.davidson.phonebook.addcontact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davidson.phonebook.ContactDAO

class AddContactViewModelFactory(private val dao: ContactDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddContactViewModel::class.java)) {
            return AddContactViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}