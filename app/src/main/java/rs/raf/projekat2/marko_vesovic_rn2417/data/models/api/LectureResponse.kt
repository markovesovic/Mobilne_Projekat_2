package rs.raf.projekat2.marko_vesovic_rn2417.data.models.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LectureResponse(
    val id: Long,
    @Json(name = "predmet") val name: String,
    @Json(name = "tip") val type: String,
    @Json(name = "nastavnik") val teacher: String,
    @Json(name = "grupe") val groups: String,
    @Json(name = "ucionica") val classroom: String,
    @Json(name = "dan") val day: String,
    @Json(name = "termin") val time: String
)
