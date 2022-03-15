package com.lost.apptestsum.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.data.repository.UserRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBauthentication
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.domain.repository.UserRepository
import com.lost.apptestsum.domain.usecase.Registr
import com.lost.apptestsum.domain.usecase.Sign


class ActivityAuthentication : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val userRepos = UserRepositoryImp(FBauthentication())
        val registr = Registr(userRepos)
        val sign = Sign(userRepos)



        val btn_sign = findViewById<Button>(R.id.btn_sign)
        val btn_reg = findViewById<Button>(R.id.btn_reg)

        btn_sign.setOnClickListener(View.OnClickListener {
            sign.sign_in(getModel())
        })

        btn_reg.setOnClickListener(View.OnClickListener {
            registr.registration(getModel())
        })
    }

//    public override fun onStart() {
//        super.onStart()
//        val currentUser = user.currentUser
//        updateUI(currentUser)
//    }

    fun getModel():UserRegModel{
        val edMail = findViewById<EditText>(R.id.et_mail)
        val edPassw = findViewById<EditText>(R.id.et_password)
        val mail = edMail.text.toString()
        val password = edPassw.text.toString()
        if(mail.isNotEmpty()&&password.isNotEmpty()){
            val userModel = UserRegModel(mail = mail, password = password)
            return userModel
        } else {
            Toast.makeText(this, "Enter your email and/or password!",Toast.LENGTH_LONG).show()
            val userModel = UserRegModel(mail = "", password = "")
            return userModel
        }

    }
}