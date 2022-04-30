package com.lost.apptestsum.data.storage.room

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.data.storage.room.entity.DataEntity

class RoomSaveData (private val context: Context): DataStorage{

    override fun saveDataStorage(saveParam: DataModelStorage) {
        val db = Room.databaseBuilder(context,DataBase::class.java, "dataRoom").build()
        val dataDAO = db.dataDao()
        Log.d(":AAA","Save room ${saveParam.dataStorage_day.toString()}")
        dataDAO.saveDataRoom(DataEntity(data_day = saveParam.dataStorage_day.toString(),
                                        data_text = saveParam.dataStorage_text.toString(),
                                        dataID = saveParam.dataStorage_idData!!))
    }

}