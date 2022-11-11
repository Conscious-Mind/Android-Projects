package com.davidson.breakingbad.domain

data class BreakingBadCharacter(
    val characterId: Int,
    val characterName: String,
    val characterNickName: String,
    val characterBirthDate: String,
    val characterImage: String,
    val characterStatus: String,
    val characterPortrayedBy: String,
)