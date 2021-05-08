package com.ghostapps.placapp.viewModel.gameRecords

import androidx.lifecycle.MutableLiveData
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRecordsViewModel(
    private val getAllRegister: GetAllRegister,
    private val deleteRegister: DeleteRegister
): BaseViewModel() {

    val recordsList = MutableLiveData<MutableList<RecordModel>>()

    suspend fun loadRecords() {
        withContext(Dispatchers.Default) {
            recordsList.postValue(getAllRegister.execute())
        }
    }

    suspend fun deleteRegister(recordModel: RecordModel) {
            deleteRegister.execute(recordModel)
            loadRecords()
    }

}