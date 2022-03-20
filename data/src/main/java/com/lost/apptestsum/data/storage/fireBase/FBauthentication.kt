package com.lost.apptestsum.data.storage.fireBase


import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.repository.UserRepositoryImp
import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage



class FBauthentication: UserStorage {





    fun registration(dataUser: UserModelStorage){

//        val mail = dataUser.mail.toString()
//        val password = dataUser.password.toString()
//        lateinit var user: FirebaseAuth
//        user = Firebase.auth
//        if(mail.isNotEmpty()&&password.isNotEmpty()){
//            user.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(FBauthentication()){ task ->
//                if (task.isSuccessful){
//                   Log.d("AAA","FBauth -- DONE!")
//
////                    startActivity(Intent(ActivityAuthentication::class.java,MainActivity::class.java))
//
//                }
//
//            }
//        }


    }

    fun sign(){


    }
}