package br.com.bicmsystems.githubaac.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import br.com.bicmsystems.githubaac.data.local.dao.UserDAO
import br.com.bicmsystems.githubaac.data.local.db.MyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : MyDatabase {

        return Room.databaseBuilder(application,
                MyDatabase::class.java, "MyDatabase.db")
                .build()

    }

    @Provides
    @Singleton
    fun provideUserDAO(database: MyDatabase) : UserDAO {

        return database.userDAO()

    }

}