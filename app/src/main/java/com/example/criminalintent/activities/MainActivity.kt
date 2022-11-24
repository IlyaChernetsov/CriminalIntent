package com.example.criminalintent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.criminalintent.R
import com.example.criminalintent.databinding.ActivityMainBinding
import com.example.criminalintent.fragments.CrimeFragment
import com.example.criminalintent.fragments.CrimeListFragment
import java.util.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(),CrimeListFragment.Callbacks {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val crimeFragment = CrimeListFragment.newInstance()
//        val crimeFragment = BlankFragment.newInstance()
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, crimeFragment)
                .commit()
        }
        val view = binding.root
        setContentView(view)
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }
}