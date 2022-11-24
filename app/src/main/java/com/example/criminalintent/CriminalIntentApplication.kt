package com.example.criminalintent

import android.app.Application
import com.example.criminalintent.repositories.CrimeRepository

class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}