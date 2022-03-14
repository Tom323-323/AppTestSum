package com.lost.apptestsum.domain.usecase

import com.lost.apptestsum.domain.model.UserRegModel

class Sign {

    fun sign_in(objUserSign: UserRegModel) {
        val objUserSign1 = UserRegModel(mail = objUserSign.mail, password = objUserSign.password)

    }
}