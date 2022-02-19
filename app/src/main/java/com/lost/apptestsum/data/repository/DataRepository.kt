package com.lost.apptestsum.data.repository

import com.lost.apptestsum.data.storage.FBstorage
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository


class DataRepositoryImp (private val fBstorage: FBstorage): DataRepository {

    override fun saveData(saveParam: DataModel){
       return fBstorage.saveDataStorage(saveParam)
    }

    override fun readData():DataModel {
        return fBstorage.readDataStorage()
    }


}