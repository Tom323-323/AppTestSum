package com.lost.apptestsum.data.storage.fireBase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage

class FBauthentication: UserStorage {
    private lateinit var auth: FirebaseAuth

    fun sign(dataUser: UserModelStorage){
        auth= FirebaseAuth.getInstance()
        val mail = dataUser.mail.toString()
        val password = dataUser.password.toString()
        if(mail.isNotEmpty()&&password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AAA", "signInWithEmail:success")
                    } else {
                        //need a message import to ActivityAuthentication.class
                    }
                }
        }
    }

    override fun registr(saveParam: UserModelStorage) {
        auth= FirebaseAuth.getInstance()
        val mail = saveParam.mail.toString()
        val password = saveParam.password.toString()
        if (mail.isNotEmpty()&&password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener {task->
                if(task.isSuccessful){
                    Log.d("AAA","register complete")
                } else{
                    Log.d("AAA",task.exception!!.message.toString())
                    //need a message import to ActivityAuthentication.class
                }
            }
        }
    }
}