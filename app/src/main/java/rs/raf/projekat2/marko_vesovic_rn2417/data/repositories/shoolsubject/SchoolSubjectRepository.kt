package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.shoolsubjects

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.SchoolSubject

interface SchoolSubjectRepository {

    fun fetchAll(): Observable<Unit>
    fun getAll(): Observable<List<SchoolSubject>>

}