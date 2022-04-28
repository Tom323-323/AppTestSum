package com.lost.apptestsum.data.repository

import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.data.storage.room.DataBase
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository


class DataRepositoryImp (private val fBstorage: FBstorage, private val dataRoom: DataBase): DataRepository {

    override fun saveData(saveParam: DataModel){
        return fBstorage.saveDataStorage(mapToStorage(saveParam))
    }

    fun saveDataRoom(saveParam: DataModel){
        return dataRoom.saveDataStorage(mapToStorage(saveParam))
    }

    fun mapToStorage(saveParam: DataModel):DataModelStorage{
        return DataModelStorage(dataStorage_idData = saveParam.idData,dataStorage_day = saveParam.data_day, dataStorage_text = saveParam.data_text)
    }

}