package com.lost.apptestsum.data.storage.fireBase

import android.content.ContentValues.TAG
import android.util.Log
import com.google.android.gms.common.data.DataHolder
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel

class FBstorage : DataStorage {

    private val database = Firebase.database
    private lateinit var databaseR: DatabaseReference
    private val DATA_KEY: String = "DataHolder"


    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val dataFireModel = DataModel(data_text = text2,data_day = text)

        val dataFire = database.getReference(DATA_KEY)
        dataFire.push().setValue(dataFireModel)
    }

    override fun readDataStorage(): DataModelStorage {
        databaseR = Firebase.database.reference
        addPostEventListener(databaseR)

        return DataModelStorage(dataStorage_text = "88_323", dataStorage_day = "12.12.2023") // TEST!!!!!!!!!
    }

    private fun addPostEventListener(postReference: DatabaseReference){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val post = dataSnapshot.getValue<DataHolder>()

                Log.d("AAA", post.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.d("AAA", "trouble")
            }
        }
        postReference.addValueEventListener(postListener)
    }
}