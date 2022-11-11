package com.davidson.breakingbad.database

import android.content.Context
import androidx.room.*


@Dao
interface BreakingBadDao {

    @Query("SELECT * FROM databaseBreakingBad")
    fun getAllCharacterFromDb(): List<DatabaseBreakingBad>

    @Query("SELECT * FROM databaseBreakingBad WHERE characterId = :characterId")
    fun getCharacterFromDb(characterId: Int): DatabaseBreakingBad

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(strangers: List<DatabaseBreakingBad>)

    @Query("DELETE FROM databaseBreakingBad")
    fun deleteAll()
}

@Database(entities = [DatabaseBreakingBad::class], version = 1, exportSchema = false)
abstract class BreakingBadDatabase : RoomDatabase() {
    abstract val BreakingBadDao: BreakingBadDao
}

private lateinit var INSTANCE: BreakingBadDatabase

fun getDatabase(context: Context): BreakingBadDatabase {
    synchronized(BreakingBadDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                BreakingBadDatabase::class.java,
                "breakingBad"
            ).build()
        }
    }
    return INSTANCE
}