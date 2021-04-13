package com.ghostapps.placapp.viewModel.endGame

import com.ghostapps.placapp.viewModel.BaseViewModel

class EndGameViewModel (
    private val contract: EndGameContract
): BaseViewModel() {

    var winnerTeamName = ""

    fun onCreate(winnerTeamName: String) {
        this.winnerTeamName = winnerTeamName
    }

    fun onExitPressed() {
        contract.onExitPressed()
    }
}