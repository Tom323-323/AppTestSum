package com.lost.apptestsum.domain

import android.annotation.SuppressLint
import com.lost.apptestsum.domain.model.DataModel
import java.text.SimpleDateFormat
import java.util.*

class SaveData() {

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    private val currentDate = Date()
    private val day_now: String = sdf.format(currentDate)

   fun exect(objData: DataModel){
        var data_text = objData.data_text
        var data_day = objData.data_day
        //shared pref
   }


}