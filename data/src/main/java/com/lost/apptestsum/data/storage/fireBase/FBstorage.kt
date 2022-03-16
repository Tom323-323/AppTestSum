package com.lost.apptestsum.data.storage.fireBase
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.fireBase.FBstorage.Keys.ID_DATA
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class FBstorage (context: Context): DataStorage {

    val prefs: SharedPreferences = context.getSharedPreferences("IDcount", Context.MODE_PRIVATE)//delete

    private val DATA_KEY: String = "DataHolder"
    private lateinit var databaseR: DatabaseReference

    private val Context.dataStore by preferencesDataStore("app_preferences")
    private val dataStore  = context.dataStore

    private object Keys {
        val ID_DATA = intPreferencesKey("idData")
    }



    override fun saveDataStorage(saveParam: DataModelStorage) {
        val text = saveParam.dataStorage_day
        val text2 = saveParam.dataStorage_text
        val idData = dataStoradePreference()

        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)
        val dataFireModel = DataModel(idData = idData,data_text = text2, data_day = text)
        databaseR.child(idData.toString()).setValue(dataFireModel)
    }

    @SuppressLint("CommitPrefEdits")
    fun dataStoradePreference(): Int{

        val int = runBlocking { dataStorePreference() }

//        val editor = prefs.edit()
//        var idData = prefs.getInt("IDcount", 0)
//        idData=++idData
//        editor.putInt("IDcount",idData).apply()
//        return idData
        return int
    }

     suspend fun dataStorePreference(): Int{
        var idData: Int = readDataStoreIdData()
        idData=++idData
        saveDataStoreIdData(idData)
        return idData
    }


    private suspend fun saveDataStoreIdData(idData: Int){
        dataStore.edit { prefs -> prefs[ID_DATA] = idData }

    }


    private fun readDataStoreIdData() {

        val intFlow: Flow<Int> = dataStore.data
            .map { preferences -> preferences[ID_DATA] ?: 0
            }

    }




}