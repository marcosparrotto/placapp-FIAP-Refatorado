package com.ghostapps.placapp.data.records.utils

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListConverter {
    @TypeConverter
    fun toJson(value: Array<Int>): String {
        return Gson().toJson(value, Array<Int>::class.java)
    }

    @TypeConverter
    fun fromJson(value: String): Array<Int> {
        return Gson().fromJson(value, Array<Int>::class.java)
    }
}