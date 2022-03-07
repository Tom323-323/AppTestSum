package com.lost.apptestsum.data.repository


import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository


class DataRepositoryImp (private val fBstorage: FBstorage): DataRepository {

    override fun saveData(saveParam: DataModel){
        return fBstorage.saveDataStorage(mapToStorage(saveParam))
    }

    override fun readData():DataModel {
        return mapToDomain(fBstorage.readDataStorage())
    }

    fun mapToStorage(saveParam: DataModel):DataModelStorage{
        return DataModelStorage(id_storage = saveParam.id,dataStorage_day = saveParam.data_day, dataStorage_text = saveParam.data_text)
    }

    private fun mapToDomain(dataModelStorage: DataModelStorage): DataModel {
        return DataModel(id = dataModelStorage.id_storage,data_text = dataModelStorage.dataStorage_text, data_day = dataModelStorage.dataStorage_day)
    }


}