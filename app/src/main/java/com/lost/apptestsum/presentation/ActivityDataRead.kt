package com.lost.apptestsum.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.presentation.adapter.AdapterActivityRead
import com.lost.apptestsum.domain.model.DataModel

class ActivityDataRead: AppCompatActivity() {

    private  lateinit var recyclerView: RecyclerView
    private  lateinit var dataArrayList: ArrayList<DataModel>
    private  lateinit var db: DatabaseReference
    val user = Firebase.auth.currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_data)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataArrayList = arrayListOf<DataModel>()

        EventChangeListener()

    }

    private fun EventChangeListener() {

        db = FirebaseDatabase.getInstance().getReference(user!!.uid)
        db.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("AAA","Listener")
                dataArrayList.clear()
                if(snapshot.exists()){

                    for(dataSnapshot in snapshot.children){

                        val data = dataSnapshot.getValue(DataModel::class.java)
                        dataArrayList.add(data!!)

                    }

                recyclerView.adapter = AdapterActivityRead(dataArrayList)


                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }


}