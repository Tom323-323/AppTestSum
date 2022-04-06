package com.lost.apptestsum.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lost.apptestsum.data.repository.DataRepositoryImp
import com.lost.apptestsum.data.storage.fireBase.FBstorage
import com.lost.apptestsum.domain.usecase.SaveData
import com.lost.apptestsum.presentation.ViewModelMain.MainViewModel

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val dataRepository by lazy { DataRepositoryImp(FBstorage(context = context)) }

    private val saveData by lazy {SaveData(dataRepository = dataRepository)}

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dataRepository = dataRepository,saveData = saveData) as T
    }
}