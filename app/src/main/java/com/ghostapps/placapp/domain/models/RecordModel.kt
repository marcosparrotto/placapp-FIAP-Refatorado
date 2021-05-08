package com.ghostapps.placapp.domain.models

class RecordModel(
    val homeTeamName: String,
    val homeTeamSet: Int,
    val homeTeamScore: Array<Int>,

    val awayTeamName: String,
    val awayTeamSet: Int,
    val awayTeamScore: Array<Int>,

    val documentId: String = ""
)