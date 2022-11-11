package com.davidson.phonebook.addcontact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidson.phonebook.Contact
import com.davidson.phonebook.ContactDAO
import kotlinx.coroutines.launch

class AddContactViewModel(val dao: ContactDAO): ViewModel() {
    var newContactName = ""
    var newContactNumber = ""

    fun addTask() {
        viewModelScope.launch {
            val contact = Contact()
            contact.contactName = newContactName
            contact.contactNumber = newContactNumber
            dao.insert(contact)
        }
    }
}