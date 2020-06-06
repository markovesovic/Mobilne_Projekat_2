package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote

import io.reactivex.Observable
import retrofit2.http.GET
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.api.LectureResponse

interface LectureService {

    @GET("json.php")
    fun getAll(): Observable<List<LectureResponse>>

}