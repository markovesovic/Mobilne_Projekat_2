package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil

class TimetableDiffItemCallback : DiffUtil.ItemCallback<Lecture>() {

    override fun areItemsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.type == newItem.type &&
                oldItem.teacher == newItem.teacher &&
                oldItem.groups == newItem.groups &&
                oldItem.classroom == newItem.classroom &&
                oldItem.day == newItem.day &&
                oldItem.time == newItem.time
    }

}