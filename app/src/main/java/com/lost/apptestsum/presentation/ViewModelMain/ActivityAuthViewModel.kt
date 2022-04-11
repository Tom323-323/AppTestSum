package com.lost.apptestsum.presentation.ViewModelMain

import androidx.lifecycle.ViewModel
import com.lost.apptestsum.data.repository.UserRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBauthentication
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.usecase.Registr
import com.lost.apptestsum.domain.usecase.Sign

class ActivityAuthViewModel: ViewModel() {

    val userRepos = UserRepositoryImp(FBauthentication())
    val sign = Sign(userRepos)
    val registr = Registr(userRepos)

    fun sign(userRagModel: UserRegModel) {
        val userModelSign = UserRegModel(mail = userRagModel.mail, password = userRagModel.password)
        sign.sign_in(userModelSign)
    }
    
    fun registr(userRagModel: UserRegModel){
        val userModelReg = UserRegModel(mail = userRagModel.mail, password = userRagModel.password)
        registr.registration(userModelReg)
    }

}