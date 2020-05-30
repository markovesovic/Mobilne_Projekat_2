package rs.raf.projekat2.marko_vesovic_rn2417.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "schoolSubjects")
class SchoolSubjectEntity (
    @PrimaryKey val id: String,
    val name: String,
    val type: String,
    val teacher: String,
    val groups: String,
    val day: String,
    val period: String,
    val classroom: String
)