package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff.NotesDiffItemCallback
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.viewholder.NotesViewHolder

class NotesAdapter(notesDiffItemCallback: NotesDiffItemCallback) : ListAdapter<Unit, NotesViewHolder>(notesDiffItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.notes_view_holder, parent, false)
        return NotesViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val unit = getItem(position)
        holder.bind(unit)
    }

}