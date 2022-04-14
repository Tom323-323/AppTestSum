package com.lost.apptestsum.data.storage.fireBase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage

class FBauthentication: UserStorage {

    object status {
        var st: Int = 0
    }


    private lateinit var auth: FirebaseAuth


    override fun sign(saveParam: UserModelStorage){
        auth= FirebaseAuth.getInstance()

        val mail = saveParam.mail.toString()
        val password = saveParam.password.toString()

        if(mail.isNotEmpty()&&password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("AAA", "signInWithEmail:success")
                        status.st = 1
                    } else {
                        Log.d("AAA", "signInWithEmail:error")
                        status.st = 2
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
                    status.st = 3
                } else{
                    Log.d("AAA",task.exception!!.message.toString())
                    status.st = 4
                }
            }
        }
    }
}