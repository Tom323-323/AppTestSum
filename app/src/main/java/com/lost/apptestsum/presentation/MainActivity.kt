package com.lost.apptestsum.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.lost.apptestsum.R
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.domain.ReadData
import com.lost.apptestsum.domain.SaveData
import com.lost.apptestsum.domain.model.DataModel
import com.lost.apptestsum.domain.repository.DataRepository


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataRepository = DataRepositoryImp()
        val saveData = SaveData(dataRepository)
        val readData = ReadData(dataRepository)

        val edit_text = findViewById<EditText>(R.id.et_dataUser)
        val btn_save = findViewById<Button>(R.id.btn_save)
        val btn_read = findViewById<Button>(R.id.btn_read_data)

        btn_save.setOnClickListener(View.OnClickListener {
            val text = edit_text.text.toString()
            saveData.exect(DataModel(data_text = text, data_day = ""))

        })

        btn_read.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RVdata::class.java)
            startActivity(intent)
        })

    }
}