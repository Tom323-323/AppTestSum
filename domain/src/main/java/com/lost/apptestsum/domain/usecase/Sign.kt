package com.lost.apptestsum.domain.usecase

import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.repository.UserRepository

class Sign (private val userRepository: UserRepository){

    fun sign_in(objUserSign: UserRegModel) {
        val objUserSign1 = UserRegModel(mail = objUserSign.mail, password = objUserSign.password)
        userRepository.sign(objUserSign1)
    }
}