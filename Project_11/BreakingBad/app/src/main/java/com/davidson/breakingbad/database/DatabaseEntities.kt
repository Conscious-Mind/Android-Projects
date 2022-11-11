package com.davidson.breakingbad.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.davidson.breakingbad.domain.BreakingBadCharacter

@Entity(tableName = "databaseBreakingBad")
data class DatabaseBreakingBad constructor(
    @PrimaryKey(autoGenerate = false)
    val characterId: Int,
    val characterName: String,
    val characterNickName: String,
    val characterBirthDate: String,
    val characterImage: String,
    val characterStatus: String,
    val characterPortrayedBy: String,
)

fun List<DatabaseBreakingBad>.asDomainModel(): List<BreakingBadCharacter> {
    return map {
        BreakingBadCharacter(
            characterId = it.characterId,
            characterName = it.characterName,
            characterNickName = it.characterNickName,
            characterBirthDate = it.characterBirthDate,
            characterImage = it.characterImage,
            characterStatus = it.characterStatus,
            characterPortrayedBy = it.characterPortrayedBy,
        )
    }
}

fun DatabaseBreakingBad.asDomainModel(): BreakingBadCharacter {
    return BreakingBadCharacter(
        characterId = characterId,
        characterName = characterName,
        characterNickName = characterNickName,
        characterBirthDate = characterBirthDate,
        characterImage = characterImage,
        characterStatus = characterStatus,
        characterPortrayedBy = characterPortrayedBy
    )
}