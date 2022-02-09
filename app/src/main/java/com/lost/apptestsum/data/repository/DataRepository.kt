package com.lost.apptestsum.data.repository

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository




class DataRepositoryImp : DataRepository {

    private val database = Firebase.database
    private val KEY: String = "key_data"

    override fun saveData(saveParam: DataModel){
        val text = saveParam.data_day
        val text2 = saveParam.data_text
        val dataFireModel = DataModel(data_text = text2,data_day = text)


        val dataFire = database.getReference("DataHolder")
        dataFire.push().setValue(dataFireModel)



    }

    override fun readData():DataModel{
        return DataModel(data_text = "88_323", data_day = "12.12.2023") // TEST!!!!!!!!!
    }

}