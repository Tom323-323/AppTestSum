package com.lost.apptestsum.data.storage.fireBase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage


class FBauthentication: UserStorage {
    private lateinit var auth: FirebaseAuth

    fun registration(dataUser: UserModelStorage){
        auth= FirebaseAuth.getInstance()
        val mail = dataUser.mail.toString()
        val password = dataUser.password.toString()
        if (mail.isNotEmpty()&&password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener {task->
                if(task.isSuccessful){
                    Log.d("AAA","registr complete")
                }

            }
        }



    }

    fun sign(){


    }
}