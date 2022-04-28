package com.lost.apptestsum.data.storage.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lost.apptestsum.data.storage.room.entity.DataEntity

@Dao
interface DAO {

    @Query("SELECT * FROM dataRoom")
    fun getAllRoom(): List<DataEntity>

    @Delete
    fun deleteRoom(user: DataEntity)

    @Insert
    fun saveDataRoom(nameUser:DataEntity)

}