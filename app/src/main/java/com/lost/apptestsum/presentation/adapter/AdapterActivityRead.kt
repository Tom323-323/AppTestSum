package com.lost.apptestsum.presentation.adapter

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.R
import com.lost.apptestsum.domain.model.DataModel


class AdapterActivityRead(private val dataList: ArrayList<DataModel>): RecyclerView.Adapter<AdapterActivityRead.ViewHolder>() {

    val myRef = FirebaseDatabase.getInstance().reference
    val user = Firebase.auth.currentUser



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterActivityRead.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterActivityRead.ViewHolder, position: Int) {
        holder.bind(dataList[position],position)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

            fun bind(dataModel: DataModel, index:Int){
                val data_text: TextView = itemView.findViewById(R.id.data_text)
                val day_text: TextView = itemView.findViewById(R.id.day_text)
                val btn_delete: Button = itemView.findViewById(R.id.btn_delete)

                data_text.text = dataModel.data_text
                day_text.text = dataModel.data_day

                btn_delete.setOnClickListener{
                    onClickDelete(index)

                }
            }

        }

    @SuppressLint("NotifyDataSetChanged")
    private fun onClickDelete(index: Int) {

        val key = dataList[index].idData
        dataList.removeAt(index)
        //deleteRoom()

        notifyDataSetChanged()

        myRef.child(user!!.uid).child("$key").removeValue()

    }
}