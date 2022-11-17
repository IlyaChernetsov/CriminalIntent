package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.criminalintent.databinding.FragmentCrimeBinding


class CrimeFragment : Fragment() {
    private var _binding: FragmentCrimeBinding? = null
    private val binding get() = _binding!!
    private lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeBinding.inflate(inflater, container, false)
        binding.crimeDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        val titleWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        }
        binding.crimeTitle.addTextChangedListener(titleWatcher)

        binding.crimeSolved.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }
        }

    }

    companion object {
        fun newInstance() = CrimeFragment()
    }
}