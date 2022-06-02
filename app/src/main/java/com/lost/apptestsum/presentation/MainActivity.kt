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
import com.lost.apptestsum.R
import com.lost.apptestsum.databinding.ActivityMainBinding
import com.lost.apptestsum.presentation.ViewModelMain.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vm: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        mailUserShow()

        binding.btnSave.setOnClickListener(View.OnClickListener {
            val text = binding.etDataUser.text.toString()

            if(text.isEmpty()){
                Snackbar.make(binding.btnSave,"Введи вес в поле",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
            } else {
            vm.save(text)
            Snackbar.make(binding.btnSave,"Данные сохранены",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
                binding.etDataUser.text.clear()
            }
        })

        binding.btnReadData.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ActivityDataRead::class.java))
            finish()
        })

        binding.tvLogout.setOnClickListener(View.OnClickListener {
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