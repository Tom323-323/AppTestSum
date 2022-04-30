package com.lost.apptestsum.data.storage.room

import android.content.Context
import androidx.room.Room
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.data.storage.room.entity.DataEntity

class RoomSaveData (context: Context): DataStorage{

    private val context = context

    override fun saveDataStorage(saveParam: DataModelStorage) {
        val db = Room.databaseBuilder(context,DataBase::class.java, "dataRoom").build()
        val dataDAO = db.dataDao()


        dataDAO.saveDataRoom(DataEntity(data_day = saveParam.dataStorage_day.toString(),
                                        data_text = saveParam.dataStorage_text.toString(),
                                        dataID = saveParam.dataStorage_idData!!))
    }

}