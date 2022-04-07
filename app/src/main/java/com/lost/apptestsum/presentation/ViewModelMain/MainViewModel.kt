package com.lost.apptestsum.presentation.ViewModelMain

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.usecase.SaveData

class MainViewModel(private val dataRepository: DataRepositoryImp,private val saveData:SaveData): ViewModel() {

    fun save (text:String){
        saveData.exect(DataModel( idData = 0, data_text = text, data_day = ""))
    }

    fun out (){
        val user = FirebaseAuth.getInstance()
        user.signOut()
    }

    fun mailUserShow(): FirebaseUser? {
        val user = Firebase.auth.currentUser
        return user
    }



}