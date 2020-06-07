package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.data.models.Note
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.NotesContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities.ChangeNoteActivity
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
        const val CHANGE_NOTE_REQUEST_CODE = 2
    }

    private var globalSwitchState = false

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
        notesViewModel.delete(it)
        Timber.e("Dugme za brisanje")
        //filter()
    }

    private val onChangeButtonClicked: (Note) -> Unit = {
        Timber.e("Dugme za promenu")
        val intent = Intent(this.context, ChangeNoteActivity::class.java)
        intent.putExtra("id", it.id)
        intent.putExtra("title", it.title)
        intent.putExtra("content", it.content)
        intent.putExtra("archived", it.archived)
        startActivityForResult(intent, CHANGE_NOTE_REQUEST_CODE)
    }


    private val onArchiveButtonClicked: (Note) -> Unit = {
        val position = (notesRecyclerView.layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
        it.archived = !it.archived
        notesViewModel.changeArchivedStatus(it)
        Timber.e("Dugme za arhiviranje")
        resetAdapterState()
        filter()
        notesRecyclerView.scrollToPosition(position)
    }

    private fun resetAdapterState() {
        val myAdapter = notesRecyclerView.adapter
        notesRecyclerView.adapter = myAdapter
    }


    private fun initRecycler() {

        notesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        notesAdapter = NotesAdapter(NotesDiffItemCallback(), onDeleteButtonClicked, onChangeButtonClicked, onArchiveButtonClicked)
        notesRecyclerView.adapter = notesAdapter
    }

    private fun initListeners() {

        onOffSwitch.setOnCheckedChangeListener { _, it ->
            Timber.e("Onoff je promenjen")
            globalSwitchState = it
            filter()
        }

        addNoteFloatingActionButton.setOnClickListener {
            val intent = Intent(this.context, NewNoteActivity::class.java)
            startActivityForResult(intent, NEW_NOTE_REQUEST_CODE)
        }


        querySearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filter()
                return false
            }
        })

    }


    private fun filter() {
        if(querySearchView.query.toString() != "" && globalSwitchState) {
            notesViewModel.getAllByFilter(querySearchView.query.toString())
            Timber.e("Prvi filter")
        } else if (querySearchView.query.toString() == "" && !globalSwitchState) {
            notesViewModel.getAllNonArchivedNotes()
            Timber.e("Drugi filter")
        } else if ( querySearchView.query.toString() == "" && globalSwitchState) {
            notesViewModel.getAllNotes()
            Timber.e("Treci filter")
        } else if( querySearchView.query.toString() != "" && !globalSwitchState) {
            notesViewModel.getAllNonArchivedNotesByFilter(querySearchView.query.toString())
            Timber.e("Cetvrti filter")
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
                        notesViewModel.insertNote(Note(0, title, content, false))
                    }
                }
            }
            CHANGE_NOTE_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK) {
                    val title = data?.getStringExtra("title")
                    val content = data?.getStringExtra("content")
                    val id = data?.getLongExtra("id", 0)
                    val archived = data?.getBooleanExtra("archived", false)
                    if (title != null && content != null && id != null && archived != null) {
                        notesViewModel.updateNote(Note(id, title, content, archived))
                    }
                }
            }
        }
    }






    private fun initObservers() {
        notesViewModel.notesState.observe(viewLifecycleOwner, Observer {
            renderState(it)
        })
        notesViewModel.getAllNonArchivedNotes()
    }
    private fun renderState(state: NotesState) {
        when(state) {
            is NotesState.Success -> {
                notesAdapter.submitList(state.notes)
            }
            is NotesState.Error -> Toast.makeText(this.context, state.message, Toast.LENGTH_SHORT).show()
            is NotesState.SuccessMessage -> Toast.makeText(this.context, state.message, Toast.LENGTH_SHORT).show()
        }
    }

}