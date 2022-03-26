package com.lost.apptestsum.data.storage.fireBase
import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.lost.apptestsum.data.storage.DataStorage
import com.lost.apptestsum.data.storage.fireBase.FBstorage.Keys.ID_DATA
import com.lost.apptestsum.data.storage.model.DataModelStorage
import com.lost.apptestsum.domain.model.DataModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class FBstorage (context: Context): DataStorage {
    val user = Firebase.auth.currentUser

    private val DATA_KEY: String = user!!.uid//name user registr
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
        //add id user token data_key == token

        databaseR = FirebaseDatabase.getInstance().getReference(DATA_KEY)
        val dataFireModel = DataModel(idData = idData,data_text = text2, data_day = text)
        databaseR.child(idData.toString()).setValue(dataFireModel)
    }

    @SuppressLint("CommitPrefEdits")
    fun dataStoradePreference(): Int{
        val int = runBlocking { dataStorePreference() }
        //get int from server если на другом телефоне но с одним аккаунтом
        return int
    }

     suspend fun dataStorePreference(): Int{
        var idData: Int = readDataStoreIdData()?:0
        idData=++idData
        saveDataStoreIdData(idData)
        return idData
    }

    private suspend fun saveDataStoreIdData(idData: Int){
        dataStore.edit { prefs -> prefs[ID_DATA] = idData }
    }

    private suspend fun readDataStoreIdData(): Int? {
        val preference = dataStore.data.first()
        return preference[ID_DATA]
    }

}