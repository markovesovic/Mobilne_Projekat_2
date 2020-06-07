package rs.raf.projekat2.marko_vesovic_rn2417.data.models

data class UserData(
    val username: String,
    val password : String,
    val info : String
)

fun UserData.toUser() : User {
    return User(username, password)
}