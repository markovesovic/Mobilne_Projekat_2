package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff.TimetableDiffItemCallback
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.viewholder.TimetableViewHolder

class TimetableAdapter : ListAdapter<Lecture, TimetableViewHolder>(TimetableDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_timetable_lecture, parent, false)
        return TimetableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}