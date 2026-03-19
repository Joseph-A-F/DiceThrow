package edu.temple.dicethrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {
    private lateinit var dieViewModel: DieViewModel
    val DIESIDE = "sidenumber"

    val CURRENT_DIE_KEY = "current_die_key"

    lateinit var dieTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dieViewModel =
            ViewModelProvider(requireActivity())[DieViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dieViewModel.throwDie()
        dieViewModel.dieRoll.observe(requireActivity()) {
            this.dieTextView.text = it.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val value: Int? = dieViewModel.getSides().value
        if (value == null) {
            return
        }
        outState.putInt(CURRENT_DIE_KEY, value)
    }

}