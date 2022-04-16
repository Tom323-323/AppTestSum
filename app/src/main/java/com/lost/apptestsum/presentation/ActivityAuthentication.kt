package com.lost.apptestsum.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
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
import com.lost.apptestsum.data.storage.fireBase.FBauthentication
import com.lost.apptestsum.domain.model.UserRegModel
import com.lost.apptestsum.presentation.ViewModelMain.ActivityAuthViewModel

class ActivityAuthentication : AppCompatActivity() {

    var user: FirebaseAuth = Firebase.auth

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        val vm = ViewModelProvider(this).get(ActivityAuthViewModel::class.java)

        val edMail = findViewById<EditText>(R.id.et_mail)
        val edPassw = findViewById<EditText>(R.id.et_password)
        val btn_sign = findViewById<Button>(R.id.btn_sign)
        val btn_reg = findViewById<Button>(R.id.btn_reg)

        btn_sign.setOnTouchListener { view, event ->
            val mail = edMail.text.toString()
            val password = edPassw.text.toString()
            if (event!!.action == MotionEvent.ACTION_DOWN && mail.isNotEmpty() && password.isNotEmpty()) {

               vm.sign(UserRegModel(mail = mail, password = password))

            } else if (event.action == MotionEvent.ACTION_UP && mail.isNotEmpty() && password.isNotEmpty()) {
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        val i = FBauthentication.status.st
                        if (i.toString().equals("1")){
                            createAlertDialog(0)
                            Log.d("AAA","вход выполнен - $i")}
                        else{
                            Log.d("AAA","вход не выполнен - $i")
                            createAlertDialog(2)
                        }
                    },
                    1000
                )
            }else {
                Toast.makeText(
                    this@ActivityAuthentication,
                    "Enter your email and/or password!",
                    Toast.LENGTH_LONG
                ).show()
            }
            true
        }

        btn_reg.setOnTouchListener { view, event ->
            val mail = edMail.text.toString()
            val password = edPassw.text.toString()
            if (event.action == MotionEvent.ACTION_DOWN && mail.isNotEmpty() && password.isNotEmpty()) {

                vm.registr(UserRegModel(mail = mail, password = password))

            } else if (event.action == MotionEvent.ACTION_UP && mail.isNotEmpty() && password.isNotEmpty()) {
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        val i = FBauthentication.status.st
                        if (i.toString().equals("3")){
                            Log.d("AAA","регистрация выполнена - $i")
                            createAlertDialog(1)}
                        else{
                            Log.d("AAA","регистрация не выполнена - $i")
                            createAlertDialog(3)
                        }
                    },
                    1000
                )
            } else {
                Toast.makeText(
                    this@ActivityAuthentication,
                    "Enter your email and/or password!",
                    Toast.LENGTH_LONG
                ).show()
            }
            true
        }
    }



    private fun createAlertDialog (index:Int){

            if(index == 0 || index == 1){
                val view = View.inflate(this@ActivityAuthentication,R.layout.alert_dialog,null)
                val builder = AlertDialog.Builder(this@ActivityAuthentication).apply {setView(view)}
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                val btn_ok = view.findViewById<Button>(R.id.btn_ok)
                val dialog_text = view.findViewById<TextView>(R.id.dialog_text)

                if(index == 0){dialog_text.text = getText(R.string.you_are_logged)}else{dialog_text.text = getText(R.string.registration_is_done)}
                btn_ok.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()
                    dialog.context.startActivity(Intent(this@ActivityAuthentication,MainActivity::class.java))
                    finish()
                })

            } else if(index == 2||index == 3){
                val view = View.inflate(this@ActivityAuthentication,R.layout.alert_dialog_error,null)
                val builder = AlertDialog.Builder(this@ActivityAuthentication).apply {setView(view)}
                val dialog = builder.create()
                dialog.show()
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                val btn_ok = view.findViewById<Button>(R.id.btn_ok)
                val dialog_text = view.findViewById<TextView>(R.id.dialog_text)
                val i = FBauthentication.status.st_mes
                if(index == 2){dialog_text.text = getText(R.string.wrong)}else{dialog_text.text = i}

                btn_ok.setOnClickListener(View.OnClickListener {
                    dialog.dismiss()
                })
            }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = user.currentUser
        if(currentUser!=null){startActivity(Intent(this@ActivityAuthentication, MainActivity::class.java))}
    }

}




