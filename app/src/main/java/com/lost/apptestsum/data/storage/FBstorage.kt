package com.lost.apptestsum.data.storage

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.domain.model.DataModel

class FBstorage : DataStorage{

    private val database = Firebase.database
    private val DATA_KEY: String = "DataHolder"

    override fun saveDataStorage(saveParam: DataModel) {
        val text = saveParam.data_day
        val text2 = saveParam.data_text
        val dataFireModel = DataModel(data_text = text2,data_day = text)
        val dataFire = database.getReference(DATA_KEY)

        dataFire.push().setValue(dataFireModel)
    }

    override fun readDataStorage(): DataModel {
        return DataModel(data_text = "88_323", data_day = "12.12.2023") // TEST!!!!!!!!!
    }
}