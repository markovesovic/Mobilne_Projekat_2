package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.notes_view_holder.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.compat.SharedViewModelCompat.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.NotesContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff.NotesDiffItemCallback
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.viewholder.NotesViewHolder
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.NotesViewModel

class NotesAdapter(
    notesDiffItemCallback: NotesDiffItemCallback,
    private val onDeleteButtonClicked: (Note) -> Unit,
    private val onChangeButtonClicked: (Note) -> Unit,
    private val onArchiveButtonClicked: (Note) -> Unit
) : ListAdapter<Note, NotesViewHolder>(notesDiffItemCallback) {


    private val onDeleteButtonClickedInvoked: (Int) -> Unit = {
        onDeleteButtonClicked.invoke(getItem(it))
    }
    private val onChangeButtonClickedInvoked: (Int) -> Unit = {
        onChangeButtonClicked.invoke(getItem(it))
    }
    private val onArchiveButtonClickedInvoked: (Int) -> Unit = {
        onArchiveButtonClicked.invoke(getItem(it))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.notes_view_holder, parent, false)
        return NotesViewHolder(containerView, onDeleteButtonClickedInvoked, onChangeButtonClickedInvoked, onArchiveButtonClickedInvoked)
    }

    override fun onBindViewHolder(noteViewHolder: NotesViewHolder, position: Int) {
        val note = getItem(position)
        if(note.archived) {
            noteViewHolder.archiveButton.setImageResource(R.drawable.ic_unarchive)
        } else {
            noteViewHolder.archiveButton.setImageResource(R.drawable.ic_archive)
        }
        noteViewHolder.bind(note)
    }

}