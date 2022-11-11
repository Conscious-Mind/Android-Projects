package com.davidson.breakingbad.network


import com.davidson.breakingbad.database.DatabaseBreakingBad
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
//data class Test(
//    @Json(name = "appearance")
//    val appearance: List<Int>,
//    @Json(name = "birthday")
//    val birthday: String, // 09-07-1958
//    @Json(name = "char_id")
//    val charId: Int, // 1
//    @Json(name = "img")
//    val img: String, // https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg
//    @Json(name = "name")
//    val name: String, // Walter White
//    @Json(name = "nickname")
//    val nickname: String, // Heisenberg
//    @Json(name = "occupation")
//    val occupation: List<String>,
//    @Json(name = "portrayed")
//    val portrayed: String, // Bryan Cranston
//    @Json(name = "status")
//    val status: String // Deceased
//)

@JsonClass(generateAdapter = true)
data class TestNetwork(
    @Json(name = "char_id")
    val charId: Int,
    @Json(name = "birthday")
    val birthday: String, // 09-07-1958
    @Json(name = "name")
    val name: String, // Walter White
    @Json(name = "img")
    val img: String, // https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg
    @Json(name = "status")
    val status: String, // Deceased
    @Json(name = "nickname")
    val nickname: String, // Heisenberg
    @Json(name = "portrayed")
    val portrayed: String, // Bryan Cranston
    @Json(name = "occupation")
    val occupation: List<String>,
)

fun List<TestNetwork>.asDatabaseModel(): List<DatabaseBreakingBad> {
    return map {
        DatabaseBreakingBad(
            characterId = it.charId,
            characterName = it.name,
            characterNickName = it.nickname,
            characterBirthDate = it.birthday,
            characterImage = it.img,
            characterStatus = it.status,
            characterPortrayedBy = it.portrayed,
        )
    }
}