package com.lost.apptestsum.domain

import android.annotation.SuppressLint
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository
import java.text.SimpleDateFormat
import java.util.*

class SaveData(private val dataRepository: DataRepository) {

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    private val currentDate = Date()
    private val day_now: String = sdf.format(currentDate)

   fun exect(objData: DataModel){
       dataRepository.saveData(objData)

   }


}