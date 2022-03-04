package com.lost.apptestsum.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.lost.apptestsum.R
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.domain.usecase.ReadData
import com.lost.apptestsum.domain.usecase.SaveData
import com.lost.apptestsum.domain.model.DataModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataRepository = DataRepositoryImp(FBstorage())
        val saveData = SaveData(dataRepository = dataRepository)
        val readData = ReadData(dataRepository = dataRepository)

        val edit_text = findViewById<EditText>(R.id.et_dataUser)
        val btn_save = findViewById<Button>(R.id.btn_save)
        val btn_read = findViewById<Button>(R.id.btn_read_data)

        btn_save.setOnClickListener(View.OnClickListener {
            val text = edit_text.text.toString()
            if(text.isEmpty()){
                Snackbar.make(btn_save,"Введи вес в поле",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
            } else {
            saveData.exect(DataModel(data_text = text, data_day = ""))
            Snackbar.make(btn_save,"Данные сохранены",Snackbar.LENGTH_LONG)
                .setAction("OK"){ }.show()
            edit_text.setText("")
            }

        })

        btn_read.setOnClickListener(View.OnClickListener {
            val dataShow = readData.execut()
            val textShow = dataShow.data_text
            Toast.makeText(applicationContext, textShow, Toast.LENGTH_LONG).show()
        })

    }
}