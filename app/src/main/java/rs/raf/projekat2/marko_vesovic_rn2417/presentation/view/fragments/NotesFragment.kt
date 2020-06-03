package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.NotesContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities.NewNoteActivity
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter.NotesAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff.NotesDiffItemCallback
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states.NotesState
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.NotesViewModel
import timber.log.Timber

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val notesViewModel: NotesContract.ViewModel by sharedViewModel<NotesViewModel>()

    private lateinit var notesAdapter: NotesAdapter

    companion object {
        const val NEW_NOTE_REQUEST_CODE = 1
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
        initRecycler()
        initListeners()
    }

    private val onDeleteButtonClicked: (Note) -> Unit = {

    }

    private val onChangeButtonClicked: (Note) -> Unit = {

    }

    private val onArchiveButtonClicked: (Note) -> Unit = {

    }

    private fun initRecycler() {
        notesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        notesAdapter = NotesAdapter(NotesDiffItemCallback(), onDeleteButtonClicked, onChangeButtonClicked, onArchiveButtonClicked)
        notesRecyclerView.adapter = notesAdapter
    }

    private var i: Long = 10

    private fun initListeners() {
        addNoteFloatingActionButton.setOnClickListener {
//            notesViewModel.addNote(Note(i++, "Novi title $i", "Content", false))
//            Toast.makeText(this.context, "Pozvano floating dugme i dodavanje beleske", Toast.LENGTH_LONG).show()
            val intent = Intent(this.context, NewNoteActivity::class.java)
            startActivityForResult(intent, NEW_NOTE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            NEW_NOTE_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK) {
                    val title = data?.getStringExtra(NewNoteActivity.NOTE_TITLE_KEY)
                    val content = data?.getStringExtra(NewNoteActivity.NOTE_CONTENT_KEY)
                    if(title != null && content != null) {
                        notesViewModel.addNote(Note(i++, title, content, false))
                    }
                }
            }
        }
    }


    private fun initObservers() {
        notesViewModel.notesState.observe(viewLifecycleOwner, Observer {
            Timber.e(it.toString())
            renderState(it)
        })
        notesViewModel.getAllNotes()
    }
    private fun renderState(state: NotesState) {
        when(state) {
            is NotesState.Success -> {
                notesAdapter.submitList(state.notes)
            }
        }
    }


}