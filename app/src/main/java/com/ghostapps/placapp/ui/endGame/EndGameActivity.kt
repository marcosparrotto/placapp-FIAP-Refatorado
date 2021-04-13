package com.ghostapps.placapp.ui.endGame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghostapps.placapp.R
import com.ghostapps.placapp.databinding.ActivityEndGameBinding
import com.ghostapps.placapp.databinding.ActivityScoreGameBinding
import com.ghostapps.placapp.ui.gameScore.GameScoreActivity
import com.ghostapps.placapp.viewModel.endGame.EndGameContract
import com.ghostapps.placapp.viewModel.endGame.EndGameViewModel
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class EndGameActivity: AppCompatActivity(), EndGameContract {

    companion object {
        const val TIME_WINNER = "winner"
    }

    private lateinit var binding: ActivityEndGameBinding
    private val viewModel: EndGameViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_end_game)
        binding.viewModel = viewModel

        viewModel.onCreate(intent.getStringExtra(EndGameActivity.TIME_WINNER) ?: "")
    }

    override fun onExitPressed() {
        finish()
    }
}