package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = RecordEntity.TABLE_NAME)
class RecordEntity(

    @SerializedName("team_a_name")
    val homeTeamName: String,
    @SerializedName("team_a_set")
    val homeTeamSet: Int,
    @SerializedName("team_a_score1")
    val homeTeamScore1: Int,
    @SerializedName("team_a_score2")
    val homeTeamScore2: Int,
    @SerializedName("team_a_score3")
    val homeTeamScore3: Int,
    @SerializedName("team_a_score4")
    val homeTeamScore4: Int,
    @SerializedName("team_a_score5")
    val homeTeamScore5: Int,

    @SerializedName("team_b_name")
    val awayTeamName: String,
    @SerializedName("team_b_set")
    val awayTeamSet: Int,
    @SerializedName("team_b_score1")
    val awayTeamScore1: Int,
    @SerializedName("team_b_score2")
    val awayTeamScore2: Int,
    @SerializedName("team_b_score3")
    val awayTeamScore3: Int,
    @SerializedName("team_b_score4")
    val awayTeamScore4: Int,
    @SerializedName("team_b_score5")
    val awayTeamScore5: Int,

    @PrimaryKey
    @SerializedName("timestamp")
    val date: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                homeTeamName = recordModel.homeTeamName,
                homeTeamScore1 = recordModel.homeTeamScore1,
                homeTeamScore2 = recordModel.homeTeamScore2,
                homeTeamScore3 = recordModel.homeTeamScore3,
                homeTeamScore4 = recordModel.homeTeamScore4,
                homeTeamScore5 = recordModel.homeTeamScore5,
                homeTeamSet = recordModel.homeTeamSet,
                awayTeamName = recordModel.awayTeamName,
                awayTeamScore1 = recordModel.awayTeamScore1,
                awayTeamScore2 = recordModel.awayTeamScore2,
                awayTeamScore3 = recordModel.awayTeamScore3,
                awayTeamScore4 = recordModel.awayTeamScore4,
                awayTeamScore5 = recordModel.awayTeamScore5,
                awayTeamSet = recordModel.awayTeamSet,
                date = recordModel.date
            )
        }
    }

    fun toModel(): RecordModel {
        return RecordModel(
            homeTeamName = homeTeamName,
            homeTeamScore1 = homeTeamScore1,
            homeTeamScore2 = homeTeamScore2,
            homeTeamScore3 = homeTeamScore3,
            homeTeamScore4 = homeTeamScore4,
            homeTeamScore5 = homeTeamScore5,
            homeTeamSet = homeTeamSet,
            awayTeamName = awayTeamName,
            awayTeamScore1 = awayTeamScore1,
            awayTeamScore2 = awayTeamScore2,
            awayTeamScore3 = awayTeamScore3,
            awayTeamScore4 = awayTeamScore4,
            awayTeamScore5 = awayTeamScore5,
            awayTeamSet = awayTeamSet,
            date = date
        )
    }
}