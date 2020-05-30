package rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubject
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubjectResponse

interface SchoolSubjectService {

    @GET("json.php")
    fun getAll(@Query("limit") limit: Int = 100): Observable<List<SchoolSubjectResponse>>

}