package com.davidson.phonebook.addcontact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidson.phonebook.Contact
import com.davidson.phonebook.ContactDAO
import kotlinx.coroutines.launch

class AddContactViewModel(val dao: ContactDAO): ViewModel() {
    var newContactName = MutableLiveData("")
    var newContactNumber = MutableLiveData("")

    fun addTask() {
        var _contactName = newContactName.value?:""
        var _contactNumber = newContactNumber.value?:""
        viewModelScope.launch {
            val contact = Contact()
            contact.contactName = _contactName
            contact.contactNumber = _contactNumber
            dao.insert(contact)
        }
        newContactName.value = ""
        newContactNumber.value = ""
    }
}