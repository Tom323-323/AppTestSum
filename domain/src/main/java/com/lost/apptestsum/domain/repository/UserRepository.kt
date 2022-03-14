package com.lost.apptestsum.domain.repository

import com.lost.apptestsum.domain.model.UserRegModel

interface UserRepository {

    fun sign (userData: UserRegModel){

    }

    fun registr (userData: UserRegModel){

    }

}