package com.lost.apptestsum.data.storage

import com.lost.apptestsum.data.storage.model.DataModelStorage

interface DataStorage {

   fun saveDataStorage(saveParam: DataModelStorage)

}