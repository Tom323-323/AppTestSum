package com.lost.apptestsum.data.repository


import android.content.Context
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository

private lateinit var data: DatabaseReference


class DataRepositoryImp(private val context: Context) : DataRepository {

    val KEY: String = "key_data"

    override fun saveData(saveParam: DataModel){
        val text = saveParam.data_day
        Log.d("AAD", text)
        data = FirebaseDatabase.getInstance().getReference(KEY)


    }

    override fun readData():DataModel{
        return DataModel(data_text = "88_323", data_day = "12.12.2023") // TEST!!!!!!!!!
    }

}