package com.ghostapps.placapp.viewModel.gameScore

import android.content.Intent
import com.ghostapps.placapp.viewModel.BaseViewModel

class GameScoreViewModel(
    private val contract: GameScoreContract
): BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    var homeTeamScore = 0
    var awayTeamScore = 0
    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var homeTeamSet = 0
    var awayTeamSet = 0
    var formattedHomeTeamSet = "00"
    var formattedAwayTeamSet = "00"

    fun onCreate(homeTeamName: String, awayTeamName: String) {
        this.homeTeamName = homeTeamName
        this.awayTeamName = awayTeamName
    }

    fun onHomeTeamIncrease() {
        homeTeamScore++
        if (homeTeamScore > 24 && ((homeTeamScore - awayTeamScore)>1)) {
            homeTeamScore = 0
            awayTeamScore = 0
            homeTeamSet++
        }
        updateScore()
        if(homeTeamSet>2) {
            contract.homeWinner()
        }
    }

    fun onHomeTeamDecrease() {
        if (homeTeamScore > 0) homeTeamScore--
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeamScore++
        if (awayTeamScore > 24 && ((awayTeamScore - homeTeamScore)>1)) {
            homeTeamScore = 0
            awayTeamScore = 0
            awayTeamSet++
        }
        updateScore()
        if(awayTeamSet>2) {
            contract.awayWinner()
        }
    }

    fun onAwayTeamDecrease() {
        if (awayTeamScore > 0) awayTeamScore--
        updateScore()
    }

    fun onExitPressed() {
        contract.onExitPressed()
    }

    private fun updateScore() {
        formattedHomeTeamScore = String.format("%02d", homeTeamScore)
        formattedAwayTeamScore = String.format("%02d", awayTeamScore)
        formattedHomeTeamSet = String.format("%02d", homeTeamSet)
        formattedAwayTeamSet = String.format("%02d", awayTeamSet)

        notifyChange()
    }
}