package com.lost.apptestsum.domain.usecase

import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository

import java.text.SimpleDateFormat
import java.util.*

class SaveData(private val dataRepository: DataRepository) {


    @Suppress("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd_MM_yyyy")
    private val currentDate = Date()
    private val day_now: String = sdf.format(currentDate)




   fun exect(objData: DataModel){


       if(objData.data_text.toString().length>3 || objData.data_text.toString().isEmpty()){

       } else {
           val objData1 = DataModel(idData = objData.idData, data_text = objData.data_text,data_day=day_now)
           dataRepository.saveData(objData1)
       }


   }


}