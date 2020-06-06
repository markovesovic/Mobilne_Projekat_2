package rs.raf.projekat2.marko_vesovic_rn2417.data.repositories.lectures

import io.reactivex.Observable
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.local.lecture.LectureDao
import rs.raf.projekat2.marko_vesovic_rn2417.data.datasources.remote.LectureService
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Lecture
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.LectureEntity
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Resource
import timber.log.Timber

class LectureRepositoryImplementation(
    private val localDataSource: LectureDao,
    private val remoteDataSource: LectureService
) : LectureRepository {

    override fun fetchAll(): Observable<Resource<Unit>> {
        return remoteDataSource
            .getAll()
            .doOnNext {
                Timber.e("Upis u bazu")
                val entities = it.map {
                    LectureEntity(
                        it.id,
                        it.name,
                        it.type,
                        it.teacher,
                        it.groups,
                        it.classroom,
                        it.day,
                        it.time
                    )
                }
                localDataSource.deleteAndInsertAll(entities)
            }
            .map {
                Resource.Success(Unit)
            }
    }

    override fun getAll(): Observable<List<Lecture>> {
        return localDataSource
            .getAll()
            .map {
                it.map {
                    Lecture(
                        it.id,
                        it.name,
                        it.type,
                        it.teacher,
                        it.groups,
                        it.classroom,
                        it.day,
                        it.time
                    )
                }
            }
    }

}