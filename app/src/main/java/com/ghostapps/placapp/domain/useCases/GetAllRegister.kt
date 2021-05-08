package com.ghostapps.placapp.domain.useCases

import com.ghostapps.placapp.domain.models.RecordModel

interface GetAllRegister {
    suspend fun execute(): MutableList<RecordModel>
}

