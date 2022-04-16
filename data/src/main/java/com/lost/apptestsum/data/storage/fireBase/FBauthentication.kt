package com.lost.apptestsum.data.storage.fireBase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.lost.apptestsum.data.storage.UserStorage
import com.lost.apptestsum.data.storage.model.UserModelStorage

class FBauthentication: UserStorage {

    object status {
        var st: Int = 0
        var st_mes: String = ""
    }
    private lateinit var auth: FirebaseAuth

    override fun sign(saveParam: UserModelStorage){
        auth= FirebaseAuth.getInstance()

        val mail = saveParam.mail.toString()
        val password = saveParam.password.toString()

        auth.signInWithEmailAndPassword(mail, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                status.st = 1
                Log.d("AAA","сервер вход выполнен + ${status.st}")
            } else {
                status.st = 2
                Log.d("AAA","сервер ошибка входа + ${status.st}")
            }
        }

    }

    override fun registr(saveParam: UserModelStorage) {
        auth= FirebaseAuth.getInstance()
        val mail = saveParam.mail.toString()
        val password = saveParam.password.toString()

        auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener {task->
            if(task.isSuccessful){
                status.st = 3
                Log.d("AAA","сервер регистрация выполнена - ${status.st}")
            } else{
                status.st = 4
                Log.d("AAA",task.exception!!.message.toString() + "${status.st}")
                status.st_mes = task.exception!!.message.toString()
            }
        }
    }
}