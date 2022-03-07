package com.lost.apptestsum.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lost.apptestsum.R
import com.lost.apptestsum.domain.model.DataModel

class AdapterActivityRead(private val dataList: ArrayList<DataModel>): RecyclerView.Adapter<AdapterActivityRead.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterActivityRead.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterActivityRead.ViewHolder, position: Int) {
       val data: DataModel = dataList[position]
        holder.data_text.text = data.data_text
        holder.day_text.text = data.data_day

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
        class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val data_text: TextView = itemView.findViewById(R.id.data_text)
            val day_text: TextView = itemView.findViewById(R.id.day_text)
        }
}