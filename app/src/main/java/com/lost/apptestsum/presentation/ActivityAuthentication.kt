package com.lost.apptestsum.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.lost.apptestsum.R
import com.lost.apptestsum.domain.model.UserRegModel


class ActivityAuthentication : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)


        val btn_sign = findViewById<Button>(R.id.btn_sign)
        val btn_reg = findViewById<Button>(R.id.btn_reg)
        val edMail = findViewById<EditText>(R.id.et_mail)// remember delete when realisation in fun getModel()
        val edPassw = findViewById<EditText>(R.id.et_password)// remember delete when realisation in fun getModel()

        btn_sign.setOnClickListener(View.OnClickListener {
            getModel()

        })

        btn_reg.setOnClickListener(View.OnClickListener {
            getModel()

        })
    }


    fun getModel():UserRegModel{
        val edMail = findViewById<EditText>(R.id.et_mail)
        val edPassw = findViewById<EditText>(R.id.et_password)
        val mail = edMail.text.toString()
        val password = edPassw.text.toString()
        if(mail.isNotEmpty()&&password.isNotEmpty()){
            val userModel = UserRegModel(mail = mail, password = password)
            return userModel
        } else {
            Toast.makeText(this, "Enter your email and password!",Toast.LENGTH_LONG).show()
            val userModel = UserRegModel(mail = "", password = "")
            return userModel
        }

    }
}