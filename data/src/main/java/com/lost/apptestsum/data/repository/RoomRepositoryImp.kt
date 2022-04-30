package com.lost.apptestsum.data.repository

import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.data.storage.room.RoomSaveData
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository

class RoomRepositoryImp(private val roomData: RoomSaveData):DataRepository {

    override fun saveData(saveParam: DataModel) {
       roomData.saveDataStorage(mapToStorage(saveParam))
    }

    private fun mapToStorage(saveParam: DataModel): DataModelStorage {
        return DataModelStorage(dataStorage_idData = saveParam.idData,dataStorage_day = saveParam.data_day, dataStorage_text = saveParam.data_text)
    }
}