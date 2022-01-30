package com.lost.apptestsum.data.repository

import com.lost.apptestsum.domain.model.DataModel

class DataRepository {

    fun saveData(saveParam: DataModel){


    }

    fun readData():DataModel{
        return DataModel(data_text = "88", data_day = "12.12.2023") // TEST!!!!!!!!!
    }

}