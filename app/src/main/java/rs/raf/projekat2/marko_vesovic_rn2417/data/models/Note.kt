package rs.raf.projekat2.marko_vesovic_rn2417.data.models

data class Note(
    val id: Long,
    var title: String,
    var content: String,
    var archived: Boolean
)