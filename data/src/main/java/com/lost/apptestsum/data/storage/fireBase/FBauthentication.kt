package com.lost.apptestsum.data.storage.fireBase

import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage

class FBauthentication: UserStorage {

    fun registration(dataUser: UserModelStorage){

        val mail = dataUser.mail
        val password = dataUser.password

    }

    fun sign(){


    }
}