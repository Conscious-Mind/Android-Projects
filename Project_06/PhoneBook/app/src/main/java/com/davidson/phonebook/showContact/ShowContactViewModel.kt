package com.davidson.phonebook.showContact

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidson.phonebook.Contact
import com.davidson.phonebook.ContactDAO
import kotlinx.coroutines.launch

class ShowContactViewModel(dao: ContactDAO): ViewModel() {
    private val contacts = dao.getAll()
    val contactsString = Transformations.map(contacts) {
            contacts -> formatContacts(contacts)
    }

    fun formatContacts(contacts: List<Contact>): String {
        return contacts.fold("") {
                str, item -> str + '\n' + formatContact(item)
        }
//        val sb = StringBuilder()
//        for (c in contacts)
//        sb.append(c.contactName+"\n")
//        return sb.toString()
    }

    fun formatContact(contact: Contact): String {
        var str = "ID: ${contact.contactId}"
        str += '\n' + "Name: ${contact.contactName}"
        str += '\n' + "Number: ${contact.contactNumber}" + '\n'
        return str
    }
}