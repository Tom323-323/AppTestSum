package com.lost.apptestsum.data.repository


import android.util.Log
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository


class DataRepositoryImp : DataRepository {

    override fun saveData(saveParam: DataModel){
        val text = saveParam.data_day
        Log.d("AAD", text)

    }

    override fun readData():DataModel{
        return DataModel(data_text = "88_323", data_day = "12.12.2023") // TEST!!!!!!!!!
    }

}