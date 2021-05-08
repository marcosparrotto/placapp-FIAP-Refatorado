package com.ghostapps.placapp.domain.useCases

import com.ghostapps.placapp.domain.models.RecordModel

interface DeleteRegister {
    suspend fun execute(recordModel: RecordModel)
}