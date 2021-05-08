package com.ghostapps.placapp.viewModel.gameScore

import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(
    private val contract: GameScoreContract,
    private val insertRegister: InsertRegister
) : BaseViewModel() {

    var homeTeamName = ""
    var awayTeamName = ""

    var homeTeamScore = 0
    var awayTeamScore = 0
    var formattedHomeTeamScore = "00"
    var formattedAwayTeamScore = "00"

    var rodadaNumber = 1
    var homeTeamScore1 = 0
    var awayTeamScore1 = 0
    var homeTeamScore2 = 0
    var awayTeamScore2 = 0
    var homeTeamScore3 = 0
    var awayTeamScore3 = 0
    var homeTeamScore4 = 0
    var awayTeamScore4 = 0
    var homeTeamScore5 = 0
    var awayTeamScore5 = 0

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
        if (homeTeamScore > 24 && ((homeTeamScore - awayTeamScore) > 1)) {
            when (rodadaNumber) {
                1 -> {
                    homeTeamScore1 = homeTeamScore
                    awayTeamScore1 = awayTeamScore
                }
                2 -> {
                    homeTeamScore2 = homeTeamScore
                    awayTeamScore2 = awayTeamScore
                }
                3 -> {
                    homeTeamScore3 = homeTeamScore
                    awayTeamScore3 = awayTeamScore
                }
                4 -> {
                    homeTeamScore4 = homeTeamScore
                    awayTeamScore4 = awayTeamScore
                }
                5 -> {
                    homeTeamScore5 = homeTeamScore
                    awayTeamScore5 = awayTeamScore
                }
            }
            rodadaNumber++
            homeTeamScore = 0
            awayTeamScore = 0
            homeTeamSet++
        }
        updateScore()
        if (homeTeamSet > 2) {
            contract.homeWinner()
            Thread {
                val success = insertRegister.execute(
                    RecordModel(
                        homeTeamName = homeTeamName,
                        homeTeamScore = arrayOf(
                            homeTeamScore1,
                            homeTeamScore2,
                            homeTeamScore3,
                            homeTeamScore4,
                            homeTeamScore5
                        ),
                        homeTeamSet = homeTeamSet,
                        awayTeamName = awayTeamName,
                        awayTeamScore = arrayOf(
                            awayTeamScore1,
                            awayTeamScore2,
                            awayTeamScore3,
                            awayTeamScore4,
                            awayTeamScore5
                        ),
                        awayTeamSet = awayTeamSet
                    )
                )

                contract.onExitPressed()

            }.start()

        }
    }

    fun onHomeTeamDecrease() {
        if (homeTeamScore > 0) homeTeamScore--
        updateScore()
    }

    fun onAwayTeamIncrease() {
        awayTeamScore++
        if (awayTeamScore > 24 && ((awayTeamScore - homeTeamScore) > 1)) {
            when (rodadaNumber) {
                1 -> {
                    homeTeamScore1 = homeTeamScore
                    awayTeamScore1 = awayTeamScore
                }
                2 -> {
                    homeTeamScore2 = homeTeamScore
                    awayTeamScore2 = awayTeamScore
                }
                3 -> {
                    homeTeamScore3 = homeTeamScore
                    awayTeamScore3 = awayTeamScore
                }
                4 -> {
                    homeTeamScore4 = homeTeamScore
                    awayTeamScore4 = awayTeamScore
                }
                5 -> {
                    homeTeamScore5 = homeTeamScore
                    awayTeamScore5 = awayTeamScore
                }
            }
            rodadaNumber++
            homeTeamScore = 0
            awayTeamScore = 0
            awayTeamSet++
        }
        updateScore()
        if (awayTeamSet > 2) {
            contract.awayWinner()
            Thread {
                val success = insertRegister.execute(
                    RecordModel(
                        homeTeamName = homeTeamName,
                        homeTeamScore = arrayOf(
                            homeTeamScore1,
                            homeTeamScore2,
                            homeTeamScore3,
                            homeTeamScore4,
                            homeTeamScore5
                        ),
                        homeTeamSet = homeTeamSet,
                        awayTeamName = awayTeamName,
                        awayTeamScore = arrayOf(
                            awayTeamScore1,
                            awayTeamScore2,
                            awayTeamScore3,
                            awayTeamScore4,
                            awayTeamScore5
                        ),
                        awayTeamSet = awayTeamSet
                    )
                )

                contract.onExitPressed()

            }.start()
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