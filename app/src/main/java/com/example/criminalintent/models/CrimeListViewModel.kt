package com.example.criminalintent.models

import androidx.lifecycle.ViewModel
import com.example.criminalintent.repositories.CrimeRepository

class CrimeListViewModel: ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}