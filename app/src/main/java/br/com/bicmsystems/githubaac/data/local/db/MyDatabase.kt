package br.com.bicmsystems.githubaac.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.bicmsystems.githubaac.data.local.converter.DateConverter
import br.com.bicmsystems.githubaac.data.local.dao.UserDAO
import br.com.bicmsystems.githubaac.data.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {

        private val INSTANCE: MyDatabase? = null

    }

}