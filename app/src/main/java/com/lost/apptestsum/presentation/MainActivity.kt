package com.lost.apptestsum.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.domain.usecase.SaveData
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.presentation.ViewModelMain.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        mailUserShow()

        val dataRepository = DataRepositoryImp(FBstorage(context = applicationContext))


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
            vm.save(text)
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
            vm.out()
            startActivity(Intent(this,ActivityAuthentication::class.java))
            finish()
        })

    }

    fun mailUserShow(){
        val usermail = findViewById<TextView>(R.id.name_mail)
        usermail.text = vm.mailUserShow()?.email.toString()
    }

}