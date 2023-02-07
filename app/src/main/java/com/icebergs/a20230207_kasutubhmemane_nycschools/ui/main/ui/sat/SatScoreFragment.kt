package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.ui.sat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.icebergs.a20230207_kasutubhmemane_nycschools.R
import com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.database.model.SATScoreDto


class SatScoreFragment : Fragment() {


    private lateinit var satScore: SATScoreDto
    private lateinit var viewModel: SatScoreViewModel
    private var dbnTv: TextView? = null
    private var schoolNameTv: TextView? = null
    private var numberOfSatTestTakerTv: TextView? = null
    private var satCriticalReadingAvgScoreTv: TextView? = null
    private var satMathAvgScoreTv: TextView? = null
    private var satWritingAvgScoreTv: TextView? = null


    val args: SatScoreFragmentArgs by navArgs()

    companion object {
        private const val ARG_SAT_SCORE = "arg_sat_score"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SatScoreViewModel::class.java)
        setObservers()
    }

    private fun setObservers() {
        viewModel.dbn.observe(this) {
            it?.let {
                dbnTv?.text = it
            }
        }
        viewModel.schoolName.observe(this) {
            it?.let {
                schoolNameTv?.text = it
            }
        }
        viewModel.numOfSatTestTakers.observe(this) {
            it?.let {
                numberOfSatTestTakerTv?.text = it
            }
        }
        viewModel.satCriticalReadingAvgScore.observe(this) {
            it?.let {
                satCriticalReadingAvgScoreTv?.text = it
            }
        }
        viewModel.satMathAvgScore.observe(this) {
            it?.let {
                satMathAvgScoreTv?.text = it
            }
        }
        viewModel.satWritingAvgScore.observe(this) {
            it?.let {
                satWritingAvgScoreTv?.text = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sat_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbnTv = view.findViewById<TextView>(R.id.dbnTv)
        schoolNameTv = view.findViewById<TextView>(R.id.schoolNameTv)
        numberOfSatTestTakerTv = view.findViewById<TextView>(R.id.numberOfSatTestTakerTv)
        satCriticalReadingAvgScoreTv =
            view.findViewById<TextView>(R.id.satCriticalReadingAvgScoreTv)
        satMathAvgScoreTv = view.findViewById<TextView>(R.id.satMathAvgScoreTv)
        satWritingAvgScoreTv = view.findViewById<TextView>(R.id.satWritingAvgScoreTv)
        // Access the SATScoreDto object here and use it to populate the UI
        try {
            val satScore: SATScoreDto = args.satScore
            viewModel.getDataWithMessage(satScore)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}