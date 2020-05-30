package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_notes.*
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter.NotesAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.diff.NotesDiffItemCallback

class NotesFragment : Fragment(R.layout.fragment_notes) {

    lateinit var notesAdapter: NotesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initRecycler()
    }

    private fun initRecycler() {
        notesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        notesAdapter = NotesAdapter(NotesDiffItemCallback())
        notesRecyclerView.adapter = notesAdapter
    }

}