package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.notes_view_holder.*
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note

class NotesViewHolder(
    override val containerView : View,
    private val onDeleteButtonClicked: (Int) -> Unit,
    private val onChangeButtonClicked: (Int) -> Unit,
    private val onArchiveButtonClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        deleteButton.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onDeleteButtonClicked.invoke(adapterPosition)
            }
        }
        changeButton.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onChangeButtonClicked.invoke(adapterPosition)
            }
        }
        archiveButton.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION) {
                onArchiveButtonClicked.invoke(adapterPosition)
            }
        }
    }

    fun bind(note: Note) {
        noteTitleEditText.text = note.title
        noteContentEditText.text = note.content
    }
}