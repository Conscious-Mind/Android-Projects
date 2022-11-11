package com.davidson.phonebook

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactDAO {
    @Insert
    suspend fun insert(contact: Contact)
    @Update
    suspend fun update(contact: Contact)
    @Delete
    suspend fun delete(contact: Contact)
    @Query("SELECT * FROM contact_table WHERE contactId = :key")
    fun get(key: Long): LiveData<Contact>
    @Query("SELECT * FROM contact_table ORDER BY contact_name ASC")
    fun getAll(): LiveData<List<Contact>>
}