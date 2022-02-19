package com.lost.apptestsum.data.storage

import com.lost.apptestsum.domain.model.DataModel

interface DataStorage {

   fun saveDataStorage(saveParam: DataModel)



   fun readDataStorage():DataModel


}