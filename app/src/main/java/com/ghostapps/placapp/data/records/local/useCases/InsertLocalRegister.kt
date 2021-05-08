package com.ghostapps.placapp.data.records.local.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.google.firebase.firestore.FirebaseFirestore

class InsertLocalRegister(
    private val database: FirebaseFirestore
): InsertRegister {
    override fun execute(recordModel: RecordModel) {
        val docData = database.collection(RecordEntity.TABLE_NAME).document()

        docData.set(RecordEntity.fromModel(recordModel))
    }
}