package com.ghostapps.placapp.domain.models

class RecordModel(
    val homeTeamName: String,
    val homeTeamSet: Int,
    val homeTeamScore1: Int,
    val homeTeamScore2: Int,
    val homeTeamScore3: Int,
    val homeTeamScore4: Int,
    val homeTeamScore5: Int,


    val awayTeamName: String,
    val awayTeamSet: Int,
    val awayTeamScore1: Int,
    val awayTeamScore2: Int,
    val awayTeamScore3: Int,
    val awayTeamScore4: Int,
    val awayTeamScore5: Int,

    val date: Long
)