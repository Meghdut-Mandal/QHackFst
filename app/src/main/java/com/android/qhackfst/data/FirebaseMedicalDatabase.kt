package com.android.qhackfst.data

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.koin.core.KoinComponent

class FirebaseMedicalDatabase  {

    private val database by lazy { Firebase.database.reference }

    init {
        database
    }


    fun insertRecord(medicalRecord: MedicalRecord){

    }



}