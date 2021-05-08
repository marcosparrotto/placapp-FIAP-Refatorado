package com.ghostapps.placapp.data.records.local.useCases


import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class DeleteLocalRegister(
    private val database: FirebaseFirestore
) : DeleteRegister {
    override suspend fun execute(recordModel: RecordModel) {
        database.collection(RecordEntity.TABLE_NAME).document(recordModel.documentId)
            .delete()
            .await()
    }
}