package com.lost.apptestsum.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lost.apptestsum.data.storage.room.entity.DataEntity


@Database (entities = [DataEntity::class], version = 1)
abstract class DataBase: RoomDatabase() {
        abstract fun dataDao():DAO
}