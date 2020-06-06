package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_timetable_lecture.*

class TimetableViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(lecture: Lecture) {
        lectureNameTv.text = lecture.name
        typeTv.text = lecture.type
        teacherTv.text = lecture.teacher
        classroomTv.text = lecture.classroom
        groupsTv.text = lecture.groups
        dayTv.text = lecture.day
        timeTv.text = lecture.time
    }

}