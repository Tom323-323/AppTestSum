package com.lost.apptestsum.domain.usecase

import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.repository.UserRepository

class Registr (private val userRepository: UserRepository){

    fun registration(objUserReg: UserRegModel){
        val objUserReg1 = UserRegModel(mail = objUserReg.mail, password = objUserReg.password)
        userRepository.registr(objUserReg1)
    }

}