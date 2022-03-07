package com.lost.apptestsum.domain.repository

import com.lost.apptestsum.domain.model.DataModel

interface DataRepository {

    fun saveData(saveParam: DataModel)

}