package rs.raf.projekat2.marko_vesovic_rn2417.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timetable")
data class LectureEntity (
    @PrimaryKey val id: Long,
    val name: String,
    val type: String,
    val teacher: String,
    val groups: String,
    val classroom: String,
    val day: String,
    val time: String
)