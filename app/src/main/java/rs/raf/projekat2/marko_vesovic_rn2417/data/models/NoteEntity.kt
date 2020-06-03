package rs.raf.projekat2.marko_vesovic_rn2417.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey val id: Long,
    var title: String,
    var content: String,
    var archived: Boolean
)