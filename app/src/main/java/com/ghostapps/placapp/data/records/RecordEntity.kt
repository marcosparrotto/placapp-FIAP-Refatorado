package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.ghostapps.placapp.data.records.utils.ListConverter
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(

    val homeTeamName: String,
    val homeTeamSet: Int,
    val homeTeamScore: Array<Int>,

    val awayTeamName: String,
    val awayTeamSet: Int,
    val awayTeamScore: Array<Int>,

    @PrimaryKey
    @SerializedName("timestamp")
    val date: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                homeTeamName = recordModel.homeTeamName,
                homeTeamScore = recordModel.homeTeamScore,
                homeTeamSet = recordModel.homeTeamSet,
                awayTeamName = recordModel.awayTeamName,
                awayTeamScore = recordModel.awayTeamScore,
                awayTeamSet = recordModel.awayTeamSet,
                date = recordModel.date
            )
        }
    }

    fun toModel(): RecordModel {
        return RecordModel(
            homeTeamName = homeTeamName,
            homeTeamScore = homeTeamScore,
            homeTeamSet = homeTeamSet,
            awayTeamName = awayTeamName,
            awayTeamScore = awayTeamScore,
            awayTeamSet = awayTeamSet,
            date = date
        )
    }
}