package com.davidson.phonebook

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var contactId: Long = 0L,
    @ColumnInfo(name = "contact_name")
    var contactName: String = "",
    @ColumnInfo(name = "contact_number")
    var contactNumber: String = ""
)