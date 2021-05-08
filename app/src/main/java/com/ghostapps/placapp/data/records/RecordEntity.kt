package com.ghostapps.placapp.data.records

import com.ghostapps.placapp.domain.models.RecordModel



class RecordEntity(

    val homeTeamName: String,
    val homeTeamSet: Int,
    val homeTeamScore: Array<Int>,

    val awayTeamName: String,
    val awayTeamSet: Int,
    val awayTeamScore: Array<Int>,

    val documentId: String = ""
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
                awayTeamSet = recordModel.awayTeamSet
            )
        }

        fun toModel(recordEntity: RecordEntity, id: String): RecordModel {
            return RecordModel(
            homeTeamName = recordEntity.homeTeamName,
            homeTeamScore = recordEntity.homeTeamScore,
            homeTeamSet = recordEntity.homeTeamSet,
            awayTeamName = recordEntity.awayTeamName,
            awayTeamScore = recordEntity.awayTeamScore,
            awayTeamSet = recordEntity.awayTeamSet,

            documentId = id
            )

        }
    }

}