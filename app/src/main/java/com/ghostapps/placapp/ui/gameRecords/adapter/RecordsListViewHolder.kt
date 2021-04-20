package com.ghostapps.placapp.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.placapp.domain.models.RecordModel
import kotlinx.android.synthetic.main.item_game_record.view.*

class RecordsListViewHolder(itemView: View, private val onDeletePressed: (recordModel: RecordModel) -> Unit): RecyclerView.ViewHolder(itemView) {

    fun bind(record: RecordModel) {
        itemView.itemGameRecordHomeTeamName.text = record.homeTeamName
        itemView.itemGameRecordHomeTeamScore1.text = record.homeTeamScore1.toString()
        itemView.itemGameRecordHomeTeamScore2.text = record.homeTeamScore2.toString()
        itemView.itemGameRecordHomeTeamScore3.text = record.homeTeamScore3.toString()
        itemView.itemGameRecordHomeTeamScore4.text = record.homeTeamScore4.toString()
        itemView.itemGameRecordHomeTeamScore5.text = record.homeTeamScore5.toString()

        itemView.itemGameRecordAwayTeamName.text = record.awayTeamName
        itemView.itemGameRecordAwayTeamScore1.text = record.awayTeamScore1.toString()
        itemView.itemGameRecordAwayTeamScore2.text = record.awayTeamScore2.toString()
        itemView.itemGameRecordAwayTeamScore3.text = record.awayTeamScore3.toString()
        itemView.itemGameRecordAwayTeamScore4.text = record.awayTeamScore4.toString()
        itemView.itemGameRecordAwayTeamScore5.text = record.awayTeamScore5.toString()

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(record)
        }
    }

}