package com.davidson.phonebook.showContact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidson.phonebook.ContactDAO
import kotlinx.coroutines.launch

class ShowContactViewModel(private var dao: ContactDAO): ViewModel() {
    val contacts = dao.getAll()

    fun clearDB() {
        viewModelScope.launch {
            dao.clear()
        }
    }
}