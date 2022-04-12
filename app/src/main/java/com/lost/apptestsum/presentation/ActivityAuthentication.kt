package com.lost.apptestsum.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.presentation.ViewModelMain.ActivityAuthViewModel

class ActivityAuthentication : AppCompatActivity() {

    var user: FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val vm = ViewModelProvider(this).get(ActivityAuthViewModel::class.java)

        val edMail = findViewById<EditText>(R.id.et_mail)
        val edPassw = findViewById<EditText>(R.id.et_password)
        val btn_sign = findViewById<Button>(R.id.btn_sign)
        val btn_reg = findViewById<Button>(R.id.btn_reg)

        btn_sign.setOnClickListener(View.OnClickListener {//добавить проверку логин и пароль

            val mail = edMail.text.toString()
            val password = edPassw.text.toString()

            if(mail.isNotEmpty()&&password.isNotEmpty()){
                vm.sign(UserRegModel(mail = mail, password = password))
                createAlertDialog(0)// need message error sign!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! FB auth
            } else{
                Toast.makeText(this@ActivityAuthentication, "Enter your email and/or password!",Toast.LENGTH_LONG).show()
            }
       })

        btn_reg.setOnClickListener(View.OnClickListener {

            val mail = edMail.text.toString()
            val password = edPassw.text.toString()

            if(mail.isNotEmpty()&&password.isNotEmpty()){
                vm.registr(UserRegModel(mail = mail, password = password))
                createAlertDialog(1)
            } else{
                Toast.makeText(this@ActivityAuthentication, "Enter your email and/or password!",Toast.LENGTH_LONG).show()
            }
        })
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = user.currentUser
        if(currentUser!=null){
            startActivity(Intent(
                this@ActivityAuthentication,
                MainActivity::class.java
            ))
        }
    }

    private fun createAlertDialog (index:Int){// перенести в usecase!!!!!
         val view = View.inflate(this@ActivityAuthentication,
                R.layout.alert_dialog,
                null)
            val builder = AlertDialog.Builder(this@ActivityAuthentication).apply {
                setView(view)}

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val btn_ok = view.findViewById<Button>(R.id.btn_ok)

            if(index==0){val dialog_text = view.findViewById<TextView>(R.id.dialog_text)
                dialog_text.text = getText(R.string.you_are_logged)}

            btn_ok.setOnClickListener(View.OnClickListener {
                dialog.dismiss()
                dialog.context.startActivity(
                    Intent(
                        this@ActivityAuthentication,
                        MainActivity::class.java
                    )
                )
                finish()
            })
         }


}