package com.lost.apptestsum.data.storage.fireBase


import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.repository.UserRepositoryImp
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
                    //start activity
                }

            }
        }



    }

    fun sign(){


    }
}