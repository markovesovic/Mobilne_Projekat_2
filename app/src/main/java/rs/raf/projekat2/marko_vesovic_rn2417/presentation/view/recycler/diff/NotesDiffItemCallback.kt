package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil

class NotesDiffItemCallback() : DiffUtil.ItemCallback<Unit>() {
    override fun areItemsTheSame(oldItem: Unit, newItem: Unit): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Unit, newItem: Unit): Boolean {
        return true
    }
}