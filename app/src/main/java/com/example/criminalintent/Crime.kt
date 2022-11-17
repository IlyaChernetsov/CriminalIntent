package com.example.criminalintent

import java.util.*

data class Crime(
    val id:UUID = UUID.randomUUID(),
    var date:Date = Date(),
    var title:String = "",
    var isSolved:Boolean = false
)
