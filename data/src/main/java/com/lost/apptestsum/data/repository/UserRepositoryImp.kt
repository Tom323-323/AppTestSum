package com.lost.apptestsum.data.repository

import com.lost.apptestsum.data.storage.fireBase.FBauthentication
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.repository.UserRepository

class UserRepositoryImp(private val fbAuth: FBauthentication): UserRepository {


    override fun registr(userData: UserRegModel) {

    }

    override fun sign(userData: UserRegModel) {

    }

    fun mapToUserModelStorage(){

    }

}