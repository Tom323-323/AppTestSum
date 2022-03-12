package com.lost.apptestsum.data.storage.fireBase

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel

class FBstorage (context: Context): DataStorage {
    val prefs: SharedPreferences = context.getSharedPreferences("IDcount", Context.MODE_PRIVATE)
    private val DATA_KEY: String = "DataHolder"
    private lateinit var databaseR: DatabaseReference


    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val idData = dataStoradePreference()

        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)
        val dataFireModel = DataModel(idData = idData,data_text = text2, data_day = text)
        databaseR.child(idData.toString()).setValue(dataFireModel)
    }

    @SuppressLint("CommitPrefEdits")
    fun dataStoradePreference(): Int{

        val editor = prefs.edit()
        var idData = prefs.getInt("IDcount", 0)
        idData=++idData
        editor.putInt("IDcount",idData).apply()
        return idData
    }

}