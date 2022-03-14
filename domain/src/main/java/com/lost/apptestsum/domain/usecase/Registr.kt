package com.lost.apptestsum.domain.usecase

import com.lost.apptestsum.domain.model.UserRegModel

class Registr {

    fun registration(objUserReg: UserRegModel){
        val objUserReg1 = UserRegModel(mail = objUserReg.mail, password = objUserReg.password)

    }

}