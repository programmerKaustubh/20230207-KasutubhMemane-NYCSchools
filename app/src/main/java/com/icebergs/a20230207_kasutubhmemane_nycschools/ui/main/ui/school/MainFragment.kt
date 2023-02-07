package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.ui.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.icebergs.a20230207_kasutubhmemane_nycschools.R
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.DatabaseStatus
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SchoolDTOEntity
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.util.OnItemClickListener

// Class that represents the main screen of the app
class MainFragment : Fragment() {

    private lateinit var viewModel: SchoolViewModel
    private lateinit var schoolsRc: RecyclerView
    private lateinit var schoolsAdapter: SchoolsAdapter
    private lateinit var tryAgainBtn: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var errorMessageTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SchoolViewModel::class.java]
        setObservers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.downloadSchoolsDatabase()
    }

    // Setting up observers for LiveData objects in the ViewModel
    private fun setObservers() {
        viewModel.schoolsVM.observe(this) {
            it?.let {
                schoolsAdapter.submitList(it as ArrayList<SchoolDTOEntity>?)
            }
        }

        viewModel.satScoreVM.observe(this) {
            it?.let {
                val action = MainFragmentDirections.actionMainFragmentToSatScoreFragment2(it)
                findNavController().navigate(action)
            }
        }

        viewModel.databaseStatusVM.observe(this) {
            it?.let {

                // Switching between different database statuses
                when (it) {
                    DatabaseStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        schoolsRc.visibility = View.GONE
                        errorMessageTv.visibility = View.GONE
                        tryAgainBtn.visibility = View.GONE
                    }
                    DatabaseStatus.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        schoolsRc.visibility = View.VISIBLE
                        errorMessageTv.visibility = View.GONE
                        tryAgainBtn.visibility = View.GONE
                    }
                    DatabaseStatus.ERROR, DatabaseStatus.NO_DATA -> {
                        progressBar.visibility = View.GONE
                        schoolsRc.visibility = View.GONE
                        errorMessageTv.visibility = View.VISIBLE
                        tryAgainBtn.visibility = View.VISIBLE
                    }
                    DatabaseStatus.NO_INTERNET -> {
                        progressBar.visibility = View.GONE
                        schoolsRc.visibility = View.GONE
                        errorMessageTv.visibility = View.VISIBLE
                        errorMessageTv.text = getString(R.string.no_internet)
                        tryAgainBtn.visibility = View.VISIBLE
                    }
                    DatabaseStatus.SAT_ERROR, DatabaseStatus.SAT_NO_DATA -> {
                        progressBar.visibility = View.GONE
                        schoolsRc.visibility = View.VISIBLE
                        errorMessageTv.visibility = View.GONE
                        tryAgainBtn.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.no_sat_data),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else -> {}
                }
            }
        }
    }

    private val clickListener =
        OnItemClickListener { school ->
            viewModel.downloadSatScore(school.dbn)
        }


    /**

    The onCreateView method is called when the fragment's view is being created. It inflates the
    fragment_main layout and sets the adapter for the schoolsRecyclerView. It sets the layout manager
    for the RecyclerView to a LinearLayoutManager and returns the inflated view.
    @param inflater The LayoutInflater object that can be used to inflate any views in the fragment.
    @param container If non-null, this is the parent view that the fragment's UI should be attached to.
    @param savedInstanceState If non-null, this fragment is being re-constructed from a previous state.
    @return The inflated view.
     **/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        schoolsRc = root.findViewById(R.id.schoolsRecyclerView)
        schoolsAdapter = SchoolsAdapter(
            arrayListOf(),
            clickListener
        )
        schoolsRc.adapter = schoolsAdapter
        schoolsRc.layoutManager = LinearLayoutManager(requireContext())
        return root
    }

    /**
    The onViewCreated method is called after the onCreateView method and is used to setup the UI
    elements of the fragment. It sets the click listener for the tryAgainButton.
    @param view The fragment's view.
    @param savedInstanceState If non-null, this fragment is being re-constructed from a previous state.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tryAgainBtn = view.findViewById(R.id.tryAgainButton)
        progressBar = view.findViewById(R.id.progressBar)
        errorMessageTv = view.findViewById(R.id.noResultsTextView)
        setClickListeners()
    }

    private fun setClickListeners() {
        tryAgainBtn.setOnClickListener {
            viewModel.downloadSchoolsDatabase()
        }
    }
}