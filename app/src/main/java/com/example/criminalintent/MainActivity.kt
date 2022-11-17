package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.criminalintent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val crimeFragment = CrimeFragment.newInstance()
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
}