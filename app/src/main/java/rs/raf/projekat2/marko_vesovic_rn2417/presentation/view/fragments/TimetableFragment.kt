package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_timetable.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.TimetableContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.recycler.adapter.TimetableAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.states.TimetableState
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.TimetableViewModel

class TimetableFragment : Fragment() {

    private val timetableViewModel: TimetableContract.ViewModel by sharedViewModel<TimetableViewModel>()
    private lateinit var adapter: TimetableAdapter
    private lateinit var gropsItems: Array<String>
    private lateinit var daysItems: Array<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        gropsItems = activity?.resources?.getStringArray(R.array.groups_array) ?: arrayOf("")
        daysItems = activity?.resources?.getStringArray(R.array.days_array) ?: arrayOf("")

        return inflater.inflate(R.layout.fragment_timetable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initRecycler()
        initListeners()
    }

    private fun initListeners() {
        initSearchButton()
        initSpinners()
    }

    private fun initSearchButton() {
        searchButton.setOnClickListener {
            filter()
        }
    }

    private fun initSpinners() {
        // set an adapter with strings array
        groupSpinner.adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, gropsItems) }

        // set click listener
        groupSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                filter()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                /*Do something if nothing selected*/
            }
        }

        // ----------------------------------------------------------------------

        // set an adapter with strings array
        daySpinner.adapter = activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, daysItems) }

        // set click listener
        daySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                filter()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                /*Do something if nothing selected*/
            }
        }
    }

    private fun filter() {
        var selectedGroup = groupSpinner.selectedItem.toString()
        var selectedDay = daySpinner.selectedItem.toString()
        val searchText = queryEditText.text.toString()

        if (selectedGroup == "All Groups" && selectedDay == "All Days" && searchText == "") {
            timetableViewModel.getAllLectures()
        } else {
            if (selectedGroup == "All Groups") {
                selectedGroup = ""
            }

            if (selectedDay == "All Days") {
                selectedDay = ""
            }

            timetableViewModel.getAllLecturesByFilters(selectedGroup, selectedDay, searchText)
        }
    }

    private fun initRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = TimetableAdapter()
        recyclerView.adapter = adapter
    }

    private fun initObservers() {
        timetableViewModel.timetableState.observe(viewLifecycleOwner, Observer {
            renderState(it)
        })
        // Pravimo subscription kad observablu koji je vezan za getAll iz baze
        // Na svaku promenu tabele, obserrvable ce emitovati na onNext sve elemente
        // koji zadovoljavaju query
        timetableViewModel.getAllLectures()
        // Pokrecemo operaciju dovlacenja podataka sa servera, kada podaci stignu,
        // bice sacuvani u bazi, tada ce se triggerovati observable na koji smo se pretplatili
        // preko metode getAllLectures()
        timetableViewModel.fetchAllLectures()
    }

    private fun renderState(state: TimetableState) {
        when (state) {
            is TimetableState.Success -> {
                showLoadingState(false)
                adapter.submitList(state.lectures)
            }
            is TimetableState.Error -> {
                showLoadingState(false)
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
            is TimetableState.DataFetched -> {
                showLoadingState(false)
                Toast.makeText(context, "Fresh data fetched from the server", Toast.LENGTH_LONG).show()
            }
            is TimetableState.Loading -> {
                showLoadingState(true)
            }
        }
    }

    private fun showLoadingState(loading: Boolean) {
        groupSpinner.isVisible = !loading
        daySpinner.isVisible = !loading
        recyclerView.isVisible = !loading
        queryEditText.isVisible = !loading
        searchButton.isVisible = !loading

        loadingPb.isVisible = loading
    }

}