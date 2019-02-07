package br.com.bicmsystems.githubaac.data.local.converter

import android.arch.persistence.room.TypeConverter
import java.util.*

object DateConverter {

    @TypeConverter
    @JvmStatic
    fun toDate(timestamp: Long?) : Date? {

        return timestamp?.let {
            Date(timestamp)
        } ?: run {
            null
        }

    }

    @TypeConverter
    @JvmStatic
    fun toTimestamp(date: Date?) : Long? {

        return date?.time

    }

}