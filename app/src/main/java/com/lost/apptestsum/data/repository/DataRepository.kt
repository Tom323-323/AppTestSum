package com.lost.apptestsum.data.repository

import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository

class DataRepositoryImp : DataRepository {

    override fun saveData(saveParam: DataModel){


    }

    override fun readData():DataModel{
        return DataModel(data_text = "88", data_day = "12.12.2023") // TEST!!!!!!!!!
    }

}