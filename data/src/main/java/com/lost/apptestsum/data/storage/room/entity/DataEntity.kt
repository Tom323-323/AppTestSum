package com.lost.apptestsum.data.storage.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class DataEntity(
        @PrimaryKey val dataID: Int,
        @ColumnInfo(name = "data_day") val data_day: String,
        @ColumnInfo(name = "data_text") val data_text: String

        )