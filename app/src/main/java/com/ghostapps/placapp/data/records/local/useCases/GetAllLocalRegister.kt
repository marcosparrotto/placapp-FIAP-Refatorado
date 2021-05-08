package com.ghostapps.placapp.data.records.local.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

class GetAllLocalRegister(
    private val database: FirebaseFirestore
) : GetAllRegister {

    override suspend fun execute(): MutableList<RecordModel> {
        val list: MutableList<RecordModel> = mutableListOf()

        val source = Source.CACHE

        val docData = database.collection(RecordEntity.TABLE_NAME)
            .get(source)
            .await()


        for(document in docData.documents){
            val toObject = document.toObject<RecordEntity>()

            list.add(RecordEntity.toModel(toObject!!, document.id))
        }

        return list
    }

}