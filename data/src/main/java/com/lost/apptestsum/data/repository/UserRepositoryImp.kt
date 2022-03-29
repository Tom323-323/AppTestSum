package com.lost.apptestsum.data.repository

import com.lost.apptestsum.data.storage.fireBase.FBauthentication
import com.lost.apptestsum.data.storage.model.UserModelStorage
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.repository.UserRepository

class UserRepositoryImp(private val fbAuth: FBauthentication): UserRepository {

    override fun registr(userData: UserRegModel) {
        return fbAuth.registr(mapToUserModelStorage(userData))
    }

    override fun sign(userData: UserRegModel) {
        return fbAuth.sign(mapToUserModelStorage(userData))
    }

    fun mapToUserModelStorage(userData: UserRegModel):UserModelStorage{
        return UserModelStorage (mail = userData.mail, password = userData.password)
    }

}