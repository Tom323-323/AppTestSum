package com.lost.apptestsum.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.domain.usecase.SaveData
import com.lost.apptestsum.domain.model.DataModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mailUserShow()

        val dataRepository = DataRepositoryImp(FBstorage(context = applicationContext))
        val saveData = SaveData(dataRepository = dataRepository)

        val editText = findViewById<EditText>(R.id.et_dataUser)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnRead = findViewById<Button>(R.id.btn_read_data)
        val btn_out = findViewById<TextView>(R.id.tv_logout)


        btnSave.setOnClickListener(View.OnClickListener {
            val text = editText.text.toString()

            if(text.isEmpty()){
                Snackbar.make(btnSave,"Введи вес в поле",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
            } else {
            saveData.exect(DataModel( idData = 0, data_text = text, data_day = ""))
            Snackbar.make(btnSave,"Данные сохранены",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
            editText.text.clear()
            }
        })

        btnRead.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ActivityDataRead::class.java))
            finish()
        })

        btn_out.setOnClickListener(View.OnClickListener {
            var user = FirebaseAuth.getInstance()
            user.signOut()
            startActivity(Intent(this,ActivityAuthentication::class.java))
        })

    }

    fun mailUserShow(){
        val user_mail = findViewById<TextView>(R.id.name_mail)
        val user = Firebase.auth.currentUser
        val mailuser = user?.email.toString()
        user_mail.text = mailuser
    }

}