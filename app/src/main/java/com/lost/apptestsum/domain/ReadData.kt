package com.lost.apptestsum.domain

import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository

class ReadData (private val dataRepository: DataRepository){

    fun execut():DataModel{
        return dataRepository.readData()
    }

}