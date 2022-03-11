package com.lost.apptestsum.data.storage.fireBase

import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel

class FBstorage : DataStorage {

    private val DATA_KEY: String = "DataHolder"
    private lateinit var databaseR: DatabaseReference


    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val idData = saveParam.dataStorage_idData

        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)
        val dataFireModel = DataModel(idData = idData,data_text = text2, data_day = text)
        databaseR.push().setValue(dataFireModel)
    }

}