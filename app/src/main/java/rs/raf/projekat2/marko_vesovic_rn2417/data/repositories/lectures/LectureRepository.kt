package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.lectures

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Lecture
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource

interface LectureRepository {

    fun fetchAll(): Observable<Resource<Unit>>
    fun getAll(): Observable<List<Lecture>>

}