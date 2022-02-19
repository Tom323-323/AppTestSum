package com.lost.apptestsum.data.storage.fireBase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel

class FBstorage : DataStorage {

    private val database = Firebase.database
    private val DATA_KEY: String = "DataHolder"

    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val dataFireModel = DataModel(data_text = text2,data_day = text)
        val dataFire = database.getReference(DATA_KEY)
        dataFire.push().setValue(dataFireModel)
    }

    override fun readDataStorage(): DataModelStorage {
        return DataModelStorage(dataStorage_text = "88_323", dataStorage_day = "12.12.2023") // TEST!!!!!!!!!
    }
}