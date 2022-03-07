package com.lost.apptestsum.data.storage.fireBase

import android.util.Log
import com.google.firebase.database.*
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel

class FBstorage : DataStorage {


    private val DATA_KEY: String = "DataHolder"
    private lateinit var databaseR: DatabaseReference


    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val id = saveParam.id_storage

        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)
        val dataFireModel = DataModel(id = id,data_text = text2, data_day = text)
        databaseR.child(id.toString()).setValue(dataFireModel)
    }




    override fun readDataStorage(): DataModelStorage {
        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)

        databaseR.child(DATA_KEY).get().addOnSuccessListener {
                val dataStorage_text = it.child("data_text").value
                val dataStorage_day = it.child("data_day").value
                val dataStorage_id = it.child("id").value
                //val dataReadModel = DataModelStorage(id_storage = dataStorage_id as Int,dataStorage_text = dataStorage_text.toString(), dataStorage_day = dataStorage_day.toString())
                Log.d("AAA","good read"+dataStorage_day.toString())
        }.addOnFailureListener{
                Log.d("AAA","error read")
        }


        return DataModelStorage(id_storage = 22,dataStorage_text = "dataStorage_text.toString()", dataStorage_day = "dataStorage_day.toString()")
    }







//    private fun addPostEventListener(postReference: DatabaseReference){
//
//        val postListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val post = dataSnapshot.getValue<DataHolder>()
//
//                Log.d("AAA", post.toString())
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Getting Post failed, log a message
//                Log.d("AAA", "trouble")
//            }
//        }
//        postReference.addValueEventListener(postListener)
//    }
}